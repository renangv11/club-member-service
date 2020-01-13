package com.visconde.clubmemberservice.converter;

import com.visconde.clubmemberservice.datacontract.ClubMemberDataContract;
import com.visconde.clubmemberservice.entities.ClubMember;
import org.springframework.stereotype.Component;
import static org.springframework.beans.BeanUtils.copyProperties;

@Component
public class ClubMemberConverter {

    public ClubMemberDataContract convertEntityToDataContract(ClubMember clubMember){
        ClubMemberDataContract clubMemberDataContract = new ClubMemberDataContract();
        copyProperties(clubMember, clubMemberDataContract);
        return clubMemberDataContract;
    }

    public ClubMember convertDataContractToEntity(ClubMemberDataContract clubMemberDataContract){
        ClubMember clubMember = new ClubMember();
        copyProperties(clubMember, clubMemberDataContract);
        return clubMember;
    }

}
