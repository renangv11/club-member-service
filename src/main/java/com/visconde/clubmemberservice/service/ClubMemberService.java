package com.visconde.clubmemberservice.service;

import com.visconde.clubmemberservice.datacontract.ClubMemberDataContract;
import com.visconde.clubmemberservice.datacontract.ClubMemberResponseDataContract;

public interface ClubMemberService {
    ClubMemberResponseDataContract createClubMember(ClubMemberDataContract clubMemberDataContract);
}
