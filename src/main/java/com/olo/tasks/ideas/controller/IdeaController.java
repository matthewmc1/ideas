package com.olo.tasks.ideas.controller;

import java.util.List;

import com.olo.tasks.ideas.entity.Ideas;
import com.olo.tasks.ideas.services.IdeaServiceInterfaceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/v1")
public class IdeaController {
    
    IdeaServiceInterfaceImpl service;

    @Autowired
    public IdeaController(IdeaServiceInterfaceImpl service) {
        this.service = service;
    }

    @GetMapping("/ideas")
    @ResponseStatus(HttpStatus.OK)
    public List<Ideas> getAllIdeas() {
        return service.getAllIdeas();
    }

    @PostMapping("/create")
    public void createIdea(Ideas idea) {
        service.createIdea(idea.getName(), null, null, null);
    }
}
