package org.example;

import java.util.Arrays;
import java.util.List;

public class Quiz {
    String questions;
    List<String> options;
    int correctOptionId;

    public Quiz(String questions, List<String> options, int correctOptionId) {
        this.questions = questions;
        this.options = options;
        this.correctOptionId = correctOptionId;
    }

    List<Quiz> quizList = Arrays.asList(
            new Quiz("Artist Marilyn Dingle’s intricate, coiled baskets are ______blank sweetgrass and palmetto palm. Following a Gullah technique that originated in West Africa, Dingle skillfully winds a thin palm frond around a bunch of sweetgrass with the help of a “sewing bone” to create the basket’s signature look that no factory can reproduce.", Arrays.asList("indicated by", "handmade from", "represented by", "collected with"), 2),
            new Quiz("The following text is adapted from Nathaniel Hawthorne’s 1837 story “Dr. Heidegger’s Experiment.” The main character, a physician, is experimenting with rehydrating a dried flower.\n" +
                    "\n" +
                    "At first [the rose] lay lightly on the surface of the fluid, appearing to imbibe none of its moisture. Soon, however, a singular change began to be visible. The crushed and dried petals stirred and assumed a deepening tinge of crimson, as if the flower were reviving from a deathlike slumber. As used in the text, what does the phrase “a singular” most nearly mean?", Arrays.asList("A lonely", "A disagreeable", "An acceptable", "An extraordinary"), 4)
            // Add up to 100+ here or load from file
    );

    public Quiz() {
    }
}
