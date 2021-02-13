package com.olo.tasks.ideas;

import java.util.Optional;

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

	/*
	* PostConstruct annotation is used to populate the database with an issue on startup for testing
	* this is using same mechanism as controller so provides some assurance that the controller will
	* work as well.
	*/
	@PostConstruct
	public void createIdeas() {
		Ideas idea = new IdeaBuilder("test").setDescription(null).setPriority(9).setGoodIdea(true).createIdea();
		serviceInterface.createIdea(idea.getName(), Optional.ofNullable(idea.getDescription()), Optional.ofNullable(idea.getPriority()), Optional.ofNullable(idea.isGoodIdea()));
	}

}
