package com.visconde.clubmemberservice.datacontract;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class ClubMemberDataContract {

    @JsonProperty("id_socio")
    private Long clubMemberId;

    @JsonProperty("nome_socio")
    private String clubMemberName;

    @JsonProperty("email_socio")
    private String clubMemberEmail;

    @JsonProperty("data_nascimento_socio")
    private LocalDate clubMemberBirthday;

    @JsonProperty("clube_socio")
    private String clubMemberTeam;

}
