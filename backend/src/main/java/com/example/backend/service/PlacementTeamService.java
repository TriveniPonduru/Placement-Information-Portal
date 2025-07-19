package com.example.backend.service;

import java.util.List;

import com.example.backend.model.PlacementTeamMember;

public interface PlacementTeamService {
    List<PlacementTeamMember> getAllMembers();
    PlacementTeamMember saveMember(PlacementTeamMember member);
}
