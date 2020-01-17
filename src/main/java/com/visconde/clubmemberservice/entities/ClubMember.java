package com.visconde.clubmemberservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "socio_torcedor")
public class ClubMember {

    @Id
    @Column(name = "id_socio")
    private Long clubMemberId;

    @Column(name = "nome_socio")
    private String clubMemberName;

    @Column(name = "email_socio", unique = true)
    private String clubMemberEmail;

    @Column(name = "data_nascimento_socio")
    private LocalDate clubMemberBirthday;

    @Column(name = "clube_socio")
    private String clubMemberTeam;

}
