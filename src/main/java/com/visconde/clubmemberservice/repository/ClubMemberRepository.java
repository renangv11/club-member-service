package com.visconde.clubmemberservice.repository;

import com.visconde.clubmemberservice.entities.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubMemberRepository extends JpaRepository<ClubMember, Long> {

    Optional<ClubMember> findByClubMemberEmail(String email);

}
