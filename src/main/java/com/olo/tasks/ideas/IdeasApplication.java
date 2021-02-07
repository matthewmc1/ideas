package com.olo.tasks.ideas;

import javax.annotation.PostConstruct;

import com.olo.tasks.ideas.entity.IdeaBuilder;
import com.olo.tasks.ideas.entity.Ideas;
import com.olo.tasks.ideas.services.IdeaServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IdeasApplication {

	@Autowired
	IdeaServiceInterface serviceInterface;

	public static void main(String[] args) {
		SpringApplication.run(IdeasApplication.class, args);
	}

	@PostConstruct
	public void createIdeas() {
		Ideas idea = new IdeaBuilder("test").createIdea();
		serviceInterface.createIdea(idea.getName(), null, null, null);
	}

}
