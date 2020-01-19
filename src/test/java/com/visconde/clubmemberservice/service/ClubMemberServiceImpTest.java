package com.visconde.clubmemberservice.service;

import com.visconde.clubmemberservice.converter.ClubMemberConverter;
import com.visconde.clubmemberservice.datacontract.ClubMemberDataContract;
import com.visconde.clubmemberservice.datacontract.ClubMemberResponseDataContract;
import com.visconde.clubmemberservice.entities.ClubMember;
import com.visconde.clubmemberservice.exceptions.AlreadyRegisteredClientException;
import com.visconde.clubmemberservice.gateway.CampaignClient;
import com.visconde.clubmemberservice.gateway.CampaignDataContract;
import com.visconde.clubmemberservice.producer.AssociateCampaignProducer;
import com.visconde.clubmemberservice.repository.ClubMemberRepository;
import com.visconde.clubmemberservice.service.imp.ClubMemberServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Long.valueOf;
import static java.time.LocalDate.of;
import static java.util.Optional.empty;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class ClubMemberServiceImpTest {

    private ClubMemberRepository clubMemberRepository = mock(ClubMemberRepository.class);
    private CampaignClient campaignClient = mock(CampaignClient.class);
    private ClubMemberConverter clubMemberConverter = mock(ClubMemberConverter.class);
    private AssociateCampaignProducer associateCampaignProducer = mock(AssociateCampaignProducer.class);

    private ClubMemberService clubMemberService = new ClubMemberServiceImp(clubMemberRepository, campaignClient, clubMemberConverter, associateCampaignProducer);

    @Test(expected = AlreadyRegisteredClientException.class)
    public void should_return_exception_already_registered_club_member(){
        when(clubMemberRepository.findByClubMemberEmail("joao.avelange@testemail.com"))
                .thenReturn(Optional.of(mockClubMemberRepository()));
        when(campaignClient.getCampaignsByTeamName(Mockito.any()))
                .thenReturn(mockCampaigns());

        clubMemberService.createClubMember(mockClubMemberDataContract());
    }

    @Test
    public void should_associate_campaigns_for_a_already_registered_club_member(){
        when(clubMemberRepository.findByClubMemberEmail("joao.avelange@testemail.com"))
                .thenReturn(Optional.of(mockClubMemberRepository()));
        when(campaignClient.getCampaignsByTeamName(Mockito.any()))
                .thenReturn(new ArrayList<>());

        ClubMemberResponseDataContract clubMember = clubMemberService.createClubMember(mockClubMemberDataContract());

        verify(associateCampaignProducer).send(any(ClubMemberDataContract.class));
        assertEquals("João Avelange", clubMember.getClubMemberDataContract().getClubMemberName());
        assertEquals(of(1994, 01, 22), clubMember.getClubMemberDataContract().getClubMemberBirthday());
        assertEquals("joao.avelange@testemail.com", clubMember.getClubMemberDataContract().getClubMemberEmail());
        assertEquals(valueOf(1), clubMember.getClubMemberDataContract().getClubMemberId());
    }

    @Test
    public void should_associate_campaigns_and_register_club_member(){
        when(clubMemberRepository.findByClubMemberEmail("joao.avelange@testemail.com"))
                .thenReturn(empty());
        when(clubMemberConverter.convertDataContractToEntity(Mockito.any(ClubMemberDataContract.class)))
                .thenReturn(mockClubMemberRepository());

        ClubMemberResponseDataContract clubMember = clubMemberService.createClubMember(mockClubMemberDataContract());

        verify(clubMemberConverter).convertDataContractToEntity(any(ClubMemberDataContract.class));
        verify(clubMemberRepository).save(Mockito.any(ClubMember.class));
        verify(associateCampaignProducer).send(any(ClubMemberDataContract.class));
        assertEquals("João Avelange", clubMember.getClubMemberDataContract().getClubMemberName());
        assertEquals(of(1994, 01, 22), clubMember.getClubMemberDataContract().getClubMemberBirthday());
        assertEquals("joao.avelange@testemail.com", clubMember.getClubMemberDataContract().getClubMemberEmail());
        assertEquals(valueOf(1), clubMember.getClubMemberDataContract().getClubMemberId());
    }

    private ClubMember mockClubMemberRepository() {
        return ClubMember.builder()
                .clubMemberName("João Avelange")
                .clubMemberBirthday(of(1994, 01, 22))
                .clubMemberEmail("joao.avelange@testemail.com")
                .clubMemberId(1l)
                .clubMemberTeam("Corinthians")
                .build();
    }

    private ClubMemberDataContract mockClubMemberDataContract() {
        return ClubMemberDataContract.builder()
                .clubMemberName("João Avelange")
                .clubMemberBirthday(of(1994, 01, 22))
                .clubMemberEmail("joao.avelange@testemail.com")
                .clubMemberId(1l)
                .clubMemberTeam("Corinthians")
                .build();
    }

    private List<CampaignDataContract> mockCampaigns() {
        List<CampaignDataContract> campaignsDataContract = new ArrayList<>();
        campaignsDataContract.add(new CampaignDataContract());
        return campaignsDataContract;
    }

}
