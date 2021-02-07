package com.olo.tasks.ideas.services;

import java.util.List;
import java.util.Optional;

import com.olo.tasks.ideas.entity.IdeaBuilder;
import com.olo.tasks.ideas.entity.Ideas;
import com.olo.tasks.ideas.repository.IdeaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdeaServiceInterfaceImpl implements IdeaServiceInterface {

    IdeaRepository repository;

    @Autowired
    public IdeaServiceInterfaceImpl(IdeaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createIdea(String name, Optional<String> description, Optional<Integer> priority, Optional<Boolean> goodIdea) {
        Ideas idea = new IdeaBuilder(name).createIdea();
        repository.save(idea);
    }

    @Override
    public List<Ideas> getAllIdeas() {
        return repository.findAll();
    }

    @Override
    public Ideas getHighestPriorityIdea() {
        List<Ideas> allIdeas = repository.findAll();
        return allIdeas.get(allIdeas.size());
    }
    
}
