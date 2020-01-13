package com.visconde.clubmemberservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
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
    private String clubMemberBirthday;

    @Column(name = "clube_socio")
    private String clubMemberTeam;

}
