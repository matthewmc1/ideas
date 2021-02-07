package com.olo.tasks.ideas.controller;

import java.util.List;

import com.olo.tasks.ideas.entity.Ideas;
import com.olo.tasks.ideas.services.IdeaServiceInterfaceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IdeaController {
    
    IdeaServiceInterfaceImpl service;

    @Autowired
    public IdeaController(IdeaServiceInterfaceImpl service) {
        this.service = service;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String defaultResponse() {
      return "Hello application user, getting there!!!";
    }

    @ResponseStatus(HttpStatus.OK)
    public List<Ideas> getAllIdeas() {
        return service.getAllIdeas();
    }

    @PostMapping("v1/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createIdea(Ideas idea) {
        service.createIdea(idea.getName(), null, null, null);
    }
}
