package com.visconde.clubmemberservice.converter;

import com.visconde.clubmemberservice.datacontract.ClubMemberDataContract;
import com.visconde.clubmemberservice.entities.ClubMember;
import org.junit.Test;

import static java.lang.Long.valueOf;
import static java.time.LocalDate.of;
import static org.junit.Assert.assertEquals;

public class ClubMemberConverterTest {

    private ClubMemberConverter clubMemberConverter = new ClubMemberConverter();

    @Test
    public void should_convert_entity_to_data_contract(){
        ClubMemberDataContract clubMemberDataContract = clubMemberConverter.convertEntityToDataContract(mockClubMemberRepository());

        assertEquals("João Avelange", clubMemberDataContract.getClubMemberName());
        assertEquals(of(1994, 01, 22), clubMemberDataContract.getClubMemberBirthday());
        assertEquals("joao.avelange@testemail.com", clubMemberDataContract.getClubMemberEmail());
        assertEquals(valueOf(1), clubMemberDataContract.getClubMemberId());
    }

    @Test
    public void should_convert_data_contract_to_entity(){
        ClubMember clubMember = clubMemberConverter.convertDataContractToEntity(mockClubMemberDataContract());

        assertEquals("João Avelange", clubMember.getClubMemberName());
        assertEquals(of(1994, 01, 22), clubMember.getClubMemberBirthday());
        assertEquals("joao.avelange@testemail.com", clubMember.getClubMemberEmail());
        assertEquals(valueOf(1), clubMember.getClubMemberId());
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
}
