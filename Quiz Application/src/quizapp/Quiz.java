package quizapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz!");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.getQuestionText());

            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            int userAnswer = getUserAnswer(scanner, options.length);
            if (q.isCorrect(userAnswer - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + (q.getCorrectAnswer() + 1));
            }
        }

        System.out.println("\nQuiz Over! Your score is: " + score + "/" + questions.size());
    }

    private int getUserAnswer(Scanner scanner, int numberOfOptions) {
        int choice = -1;
        while (choice < 1 || choice > numberOfOptions) {
            try {
                System.out.print("Your answer (1-" + numberOfOptions + "): ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > numberOfOptions) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }
}
