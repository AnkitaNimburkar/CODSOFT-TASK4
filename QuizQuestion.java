package Task4;

import java.util.ArrayList;

public class QuizQuestion {
    private final String question;
    private final ArrayList<String> options;
    private final int correctOptionIndex;

    public QuizQuestion(String question, ArrayList<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

