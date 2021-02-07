package com.olo.tasks.ideas.entity;

public final class IdeaBuilder {

    protected final String name;
    protected String description;
    protected int priority;
    protected boolean goodIdea;

    public IdeaBuilder(String name) {
        this.name = name;
    }

    public IdeaBuilder setDescription(String description) {
        this.description = description;
        return this;
    }   

    public IdeaBuilder setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public IdeaBuilder setGoodIdea(boolean goodIdea) {
        this.goodIdea = goodIdea;
        return this;
    }

    public Ideas createIdea() {
        return new Ideas(this);
    }

}

