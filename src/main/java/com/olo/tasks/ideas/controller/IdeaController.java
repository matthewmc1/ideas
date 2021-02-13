package com.olo.tasks.ideas.controller;

import java.util.List;
import java.util.Optional;

import com.olo.tasks.ideas.entity.Ideas;
import com.olo.tasks.ideas.services.IdeaServiceInterfaceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("v1/ideas")
    @ResponseStatus(HttpStatus.OK)
    public List<Ideas> getAllIdeas() {
        return service.getAllIdeas();
    }

    @GetMapping("v1/ideas/highest")
    @ResponseStatus(HttpStatus.OK)
    public Ideas getHighestPriority() {
        return service.getHighestPriorityIdea();
    }


    @PostMapping("v1/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createIdea(@RequestBody Ideas idea) {
        service.createIdea(idea.getName(), Optional.ofNullable(idea.getDescription()), Optional.ofNullable(idea.getPriority()), Optional.ofNullable(idea.isGoodIdea()));
    }
}
