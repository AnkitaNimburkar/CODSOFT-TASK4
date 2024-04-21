package Task4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplicationWithTimer {
    private static final ArrayList<QuizQuestion> questions = new ArrayList<>();
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static Timer timer;

    public static void main(String[] args) {
        initializeQuestions();
        startQuiz();
    }

    private static void initializeQuestions() {

        ArrayList<String> options1 = new ArrayList<>();
        options1.add("A. JVM");
        options1.add("B. JRE");
        options1.add("C. JDK");
        options1.add("D. JAR");
        questions.add(new QuizQuestion("Which one is used to compile a Java program?", options1, 2)); // JDK

        ArrayList<String> options2 = new ArrayList<>();
        options2.add("A. Inheritance");
        options2.add("B. Polymorphism");
        options2.add("C. Encapsulation");
        options2.add("D. Abstraction");
        questions.add(new QuizQuestion("Which concept in Java is used to bundle the data and methods that operate on the data?", options2, 2)); // Encapsulation
    }
    // You can add more questions
    private static void startQuiz() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                displayNextQuestion();
            }
        }, 15000);

        displayQuestion();
    }

    private static void displayQuestion() {
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
        System.out.println("\nQuestion: " + currentQuestion.getQuestion());
        ArrayList<String> options = currentQuestion.getOptions();
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Enter your answer (A, B, C, or D): ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine().toUpperCase();
        checkAnswer(userAnswer);
    }

    private static void checkAnswer(String userAnswer) {
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
        if (userAnswer.equals(currentQuestion.getOptions().get(currentQuestion.getCorrectOptionIndex()).substring(0, 1))) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }
        displayNextQuestion();
    }

    private static void displayNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            startQuiz();
        } else {
            endQuiz();
        }
    }

    private static void endQuiz() {
        timer.cancel();
        System.out.println("\nQuiz ended!");
        System.out.println("Your score: " + score + "/" + questions.size());

    }
}