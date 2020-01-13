package com.visconde.clubmemberservice.controller;

import com.visconde.clubmemberservice.datacontract.ClubMemberDataContract;
import com.visconde.clubmemberservice.datacontract.ClubMemberResponseDataContract;
import com.visconde.clubmemberservice.service.ClubMemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
public class ClubMemberController {

    private final ClubMemberService clubMemberService;

    @PostMapping(value = "/socio")
    public ResponseEntity<ClubMemberResponseDataContract> createClubMember(@RequestBody ClubMemberDataContract clubMemberDataContract){
        return ResponseEntity.status(CREATED).body(clubMemberService.createClubMember(clubMemberDataContract));
    }

}
