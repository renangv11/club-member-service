package com.visconde.clubmemberservice.datacontract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClubMemberDataContract {

    @JsonProperty("id_socio")
    private Long clubMemberId;

    @JsonProperty("nome_socio")
    private String clubMemberName;

    @JsonProperty("email_socio")
    private String clubMemberEmail;

    @JsonProperty("data_nascimento_socio")
    private String clubMemberBirthday;

    @JsonProperty("clube_socio")
    private String clubMemberTeam;

}
