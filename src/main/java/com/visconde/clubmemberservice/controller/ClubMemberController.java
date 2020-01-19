package com.visconde.clubmemberservice.controller;

import com.visconde.clubmemberservice.datacontract.ClubMemberDataContract;
import com.visconde.clubmemberservice.datacontract.ClubMemberResponseDataContract;
import com.visconde.clubmemberservice.service.ClubMemberService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
public class ClubMemberController {

    private final ClubMemberService clubMemberService;

    @ApiOperation(value = "Cadastra um sócio-torcedor se ele ainda não for cadastrado")
    @PostMapping(value = "/socio", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClubMemberResponseDataContract> createClubMember(@RequestBody ClubMemberDataContract clubMemberDataContract){
        return ResponseEntity.status(CREATED).body(clubMemberService.createClubMember(clubMemberDataContract));
    }

}
