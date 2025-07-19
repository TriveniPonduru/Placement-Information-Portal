package com.example.backend.service.impl;

import com.example.backend.model.PlacementTeamMember;
import com.example.backend.repository.PlacementTeamMemberRepository;
import com.example.backend.service.PlacementTeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements PlacementTeamService {

    private final PlacementTeamMemberRepository repo;

    public TeamServiceImpl(PlacementTeamMemberRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<PlacementTeamMember> getAllMembers() {
        return repo.findAll();
    }

    @Override
    public PlacementTeamMember saveMember(PlacementTeamMember member) {
        return repo.save(member);
    }
}
