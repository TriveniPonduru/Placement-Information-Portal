package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.PlacementTeamMember;

@Repository
public interface PlacementTeamMemberRepository extends JpaRepository<PlacementTeamMember, Long> {
}
