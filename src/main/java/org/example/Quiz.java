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

    static List<Quiz> quizList = Arrays.asList(
            new Quiz("Multiple newspapers ______blank the Spanish-speaking population of Washington, DC, including El Tiempo Latino and Washington Hispanic.", Arrays.asList("serve", "having served", "to serve", "serving"), 1),
            new Quiz("A cube has a surface area of 54 square meters. What is the volume, in cubic meters, of the cube?", Arrays.asList("18", "27", "36", "81"), 2)

            // Add up to 100+ here or load from file
    );

    public Quiz() {
    }
}
