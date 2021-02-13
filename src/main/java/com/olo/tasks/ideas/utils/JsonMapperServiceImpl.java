package com.olo.tasks.ideas.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.olo.tasks.ideas.entity.Ideas;
import com.olo.tasks.ideas.repository.IdeaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonMapperServiceImpl implements JsonMapperService {

    IdeaRepository repository;

    static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    @Autowired
    public JsonMapperServiceImpl(IdeaRepository repository) {
        this.repository = repository;
    }

    private static List<Ideas> getListIdeasFromJsonFile() {
        List<Ideas> parsedIdeas = new ArrayList<>();

        try {
            parsedIdeas.add(gson.fromJson(
                    new String(Files.readAllBytes(Paths.get("src\\main\\resources\\json\\ideas.json"))), Ideas.class));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return parsedIdeas;
    }

    @Override
    public void createIdeasJsonImporter() {
        List<Ideas> importedIdeas = getListIdeasFromJsonFile();

        importedIdeas.forEach(idea -> {
            System.out.println(idea.getName());
            repository.save(idea);
        });
    }

}
