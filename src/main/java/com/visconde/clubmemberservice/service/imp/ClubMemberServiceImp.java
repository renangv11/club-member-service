package com.visconde.clubmemberservice.service.imp;

import com.visconde.clubmemberservice.converter.ClubMemberConverter;
import com.visconde.clubmemberservice.datacontract.ClubMemberDataContract;
import com.visconde.clubmemberservice.datacontract.ClubMemberResponseDataContract;
import com.visconde.clubmemberservice.entities.ClubMember;
import com.visconde.clubmemberservice.exceptions.AlreadyRegisteredClientException;
import com.visconde.clubmemberservice.gateway.CampaignClient;
import com.visconde.clubmemberservice.gateway.CampaignDataContract;
import com.visconde.clubmemberservice.producer.AssociateCampaignProducer;
import com.visconde.clubmemberservice.repository.ClubMemberRepository;
import com.visconde.clubmemberservice.service.ClubMemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClubMemberServiceImp implements ClubMemberService {

    private final ClubMemberRepository clubMemberRepository;
    private final CampaignClient campaignClient;
    private final ClubMemberConverter clubMemberConverter;
    private final AssociateCampaignProducer associateCampaignProducer;

    @Override
    public ClubMemberResponseDataContract createClubMember(ClubMemberDataContract clubMemberDataContract) {
        Optional<ClubMember> clubMember =
                clubMemberRepository.findByClubMemberEmail(clubMemberDataContract.getClubMemberEmail());

        if(clubMember.isPresent()){
            return alreadyRegisteredClubMember(clubMember.get());
        }

        return registerClubMember(clubMemberDataContract);
    }

    private ClubMemberResponseDataContract alreadyRegisteredClubMember(ClubMember clubMember) {
        List<CampaignDataContract> campaigns = campaignClient.getCampaignByUserId(clubMember.getClubMemberId());

        if(!campaigns.isEmpty()){
            throw new AlreadyRegisteredClientException("Cliente já cadastrado");
        }

        associateCampaignProducer.send(clubMemberConverter.convertEntityToDataContract(clubMember));

        return ClubMemberResponseDataContract.builder()
                .campaigns(campaigns)
                .clubMemberDataContract(clubMemberConverter.convertEntityToDataContract(clubMember))
                .build();
    }

    private ClubMemberResponseDataContract registerClubMember(ClubMemberDataContract clubMemberDataContract) {
        ClubMember clubMember = clubMemberConverter.convertDataContractToEntity(clubMemberDataContract);
        clubMemberRepository.save(clubMember);

        associateCampaignProducer.send(clubMemberConverter.convertEntityToDataContract(clubMember));

        return ClubMemberResponseDataContract.builder()
                .clubMemberDataContract(clubMemberDataContract)
                .build();
    }

}
