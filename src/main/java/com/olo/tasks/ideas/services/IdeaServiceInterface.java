package com.olo.tasks.ideas.services;

import java.util.List;
import java.util.Optional;

import com.olo.tasks.ideas.entity.Ideas;

public interface IdeaServiceInterface {
 
    void createIdea(String name, Optional<String> description, Optional<Integer> priority, Optional<Boolean> goodIdea);
    List<Ideas> getAllIdeas();
    Ideas getHighestPriorityIdea();

}
