package quizapp;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Add questions to the quiz
        quiz.addQuestion(new Question(
                "What is the capital of France?",
                new String[]{"Berlin", "Madrid", "Paris", "Rome"},
                2
        ));

        quiz.addQuestion(new Question(
                "Which programming language is known as the 'Write Once, Run Anywhere' language?",
                new String[]{"Python", "Java", "C++", "JavaScript"},
                1
        ));

        quiz.addQuestion(new Question(
                "What is the largest planet in our solar system?",
                new String[]{"Earth", "Mars", "Jupiter", "Saturn"},
                2
        ));

        // Start the quiz
        quiz.start();
    }
}
