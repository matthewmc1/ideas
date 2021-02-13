package com.olo.tasks.ideas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.olo.tasks.ideas.entity.IdeaBuilder;
import com.olo.tasks.ideas.entity.Ideas;

import org.junit.jupiter.api.Test;

class IdeasApplicationTests {

    @Test
    public void givenListOfIdeas_whenSorted_thenHighestShouldBeReturned() {
        Ideas a1 = new IdeaBuilder("New1").setDescription("Test").setPriority(1).createIdea();
        Ideas b1 = new IdeaBuilder("New2").setDescription("Test").setPriority(2).createIdea();
        Ideas c1 = new IdeaBuilder("New3").setDescription("Test").createIdea();
        Ideas d1 = new IdeaBuilder("New4").setDescription("Test").setPriority(12).createIdea();
        Ideas e1 = new IdeaBuilder("New5").setDescription("Test").setPriority(0).createIdea();
		Ideas f1 = new IdeaBuilder("New6").setDescription("Test").setPriority(23).createIdea();
		Ideas g1 = new IdeaBuilder("New7").setDescription("Test").setPriority(-1).createIdea();

		//doing this way to avoid immutable list produced from List.of();
		//@matt think of a better way to do this.
        List<Ideas> allIdeas = new ArrayList<>();
		allIdeas.add(a1);
		allIdeas.add(b1);
		allIdeas.add(c1);
		allIdeas.add(d1);
		allIdeas.add(e1);
		allIdeas.add(f1);
		allIdeas.add(g1);
        allIdeas.sort((a, b) -> b.getPriority().compareTo(a.getPriority()));
		allIdeas.forEach(idea -> System.out.println(idea.getName()));

		assertEquals(23, allIdeas.get(0).getPriority());
    }

}
