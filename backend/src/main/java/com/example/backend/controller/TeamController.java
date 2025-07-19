package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.PlacementTeamMember;
import com.example.backend.service.PlacementTeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private PlacementTeamService teamService;

    @GetMapping
    public List<PlacementTeamMember> getAll() {
        return teamService.getAllMembers(); // ✅ use object, not class name
    }

    @PostMapping
    public PlacementTeamMember add(@RequestBody PlacementTeamMember member) {
        return teamService.saveMember(member);
    }
}
