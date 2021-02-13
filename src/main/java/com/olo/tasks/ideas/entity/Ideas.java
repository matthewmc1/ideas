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
    private Integer priority;
    private boolean goodIdea;

    private Ideas() {

    }

    public Ideas(String name, String description, Integer priority, Boolean goodIdea) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.goodIdea = goodIdea;
    }


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

    public Integer getPriority() {
        return priority;
    }

    public boolean isGoodIdea() {
        return goodIdea;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setGoodIdea(boolean goodIdea) {
        this.goodIdea = goodIdea;
    }

}
