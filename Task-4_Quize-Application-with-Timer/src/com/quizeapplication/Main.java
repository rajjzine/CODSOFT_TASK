package com.quizeapplication;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	static Timer timer;
	static int userScore = 0;
	static int currentQuestionIndex = 0;

	public static void main(String[] args) {
		initializeQuestions();
		beginQuiz();

	}

	static Question[] questions;

	static void initializeQuestions() {
		questions = new Question[4];

		questions[0] = new Question("Who invented Java Programming?",
				new String[] { "Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup" }, 1);
		questions[1] = new Question("Which statement is true about Java?", new String[] { "JRE", "JIT", "JDK", "JVM" },
				2);
		questions[2] = new Question("Which one of the following is not a Java feature?",
				new String[] { "Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible" }, 1);
		questions[3] = new Question("What is the extension of java code files?",
				new String[] { ".js", ".txt", ".class", ".java" }, 2);
	}

	static void beginQuiz() {

		Scanner sc = new Scanner(System.in);

		System.out.println("           Welcome to the Quiz          ");
		System.out.println("*****************************************");

		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("\nTime's up!! Moving to the next Question");
				displayNextQuestion();
			}
		}, 15000);
		displayNextQuestion();
	}

	static void displayNextQuestion() {
		if (currentQuestionIndex < questions.length) {
			Question currentQuestion = questions[currentQuestionIndex];
			System.out.println("\n" + currentQuestion.getQuestionText());

			for (int i = 0; i < currentQuestion.getOptions().length; i++) {
				System.out.println((i + 1) + ". " + currentQuestion.getOptions()[i]);
			}

			Scanner scanner = new Scanner(System.in);
			System.out.print("Select your answer (1-" + currentQuestion.getOptions().length + "): ");
			int userAnswer = scanner.nextInt() - 1;

			if (userAnswer == currentQuestion.getCorrectAnswer()) {
				userScore++;
			}

			currentQuestionIndex++;
			timer.cancel();
			timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println("\nTime's up! Moving to the next question.");
					displayNextQuestion();
				}
			}, 20000);

			displayNextQuestion();
		} else {
			endQuiz();
		}
	}

	static void endQuiz() {
		System.out.println("\nQuiz Finished!");
		System.out.println("Your score: " + userScore + "/" + questions.length);
		System.out.println("Thank you for playing!");
	}
}

class Question {
	private String questionText;
	private String[] options;
	private int correctAnswer;

	public Question(String questionText, String[] options, int correctAnswer) {
		this.questionText = questionText;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}

	public String getQuestionText() {
		return questionText;
	}

	public String[] getOptions() {
		return options;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}
}
