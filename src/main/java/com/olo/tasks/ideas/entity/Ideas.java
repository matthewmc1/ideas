package com.olo.tasks.ideas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Ideas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int priority;
    private boolean goodIdea;

    public Ideas(IdeaBuilder builder) {
        name = builder.name;
        description = builder.description;
        priority = builder.priority;
        goodIdea = builder.goodIdea;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isGoodIdea() {
        return goodIdea;
    }

    public Long getId() {
        return id;
    }

}
