package com.quizeapplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	static Timer timer;
	static Questions[] questions;
	static int currentQuestionNumber = 0;
	public static void main(String[] args) {
		
		startQuiz();
		logic();
	}
	
	static void startQuiz() {
		Scanner sc = new Scanner(System.in);
		System.out.println("           Welcome to the Quiz          ");
		System.out.println("*****************************************");
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("\nTime's up!! Moving to the next Question");
				
			}
		}, 10000);
		
	} 
	
//	static void displayNextQuestion() {
//		Questions ques = new Questions();
//		//if(currentQuestionNumber < ques.getQuestion()) {
//			
//		//}
//		
//	}
	static void logic() {
		Scanner sc = new Scanner(System.in);
		int correctAnsCount = 0;
		int wrongAnsCount = 0;
		Questions q1 = new Questions(" Who invented Java Programming?", " A. Guido van Rossum", " B. James Gosling",
				" C. Dennis Ritchie", " D. Bjarne Stroustrup");
		Questions q2 = new Questions(" Which statement is true about Java?",
				" A. Java is a sequence-dependent programming language",
				" B. Java is a code dependent programming language",
				" C. Java is a platform-dependent programming language",
				" D. Java is a platform-independent programming language");
		Questions q3 = new Questions(" Which component is used to compile, debug and execute the java programs?",
				" A. JRE", " B. JIT", " C. JDK", " D. JVM");
		Questions q4 = new Questions(" Which one of the following is not a Java feature?", " A. Object-oriented",
				" B. Use of pointers", " C. Portable", " D. Dynamic and Extensible");
		Questions q5 = new Questions(" Which of these cannot be used for a variable name in Java?",
				" A. identifier & keyword", " B. identifier", " C. keyword", " D. none of the mentioned");
		Questions q6 = new Questions(" What is the extension of java code files?", " A. .js", " B. .txt", " C. .class",
				" D. .java");
		Map<Questions, Character> qList = new HashMap<>();
		qList.put(q1, 'B');
		qList.put(q2, 'D');
		qList.put(q3, 'C');
		qList.put(q4, 'B');
		qList.put(q5, 'C');
		qList.put(q6, 'D');

		for (Map.Entry<Questions, Character> map : qList.entrySet()) {
			System.out.println(map.getKey().getQuestion());
			System.out.println(map.getKey().getOption1());
			System.out.println(map.getKey().getOption2());
			System.out.println(map.getKey().getOption3());
			System.out.println(map.getKey().getOption4());
			System.out.println("");
			System.out.print(" Enter Your Answer: ");
			Character ans = sc.next().charAt(0);

			int correctAns = Character.compare(ans, map.getValue());
			if (correctAns == 0) {
				System.out.println("correct ans is : "+ correctAns);
				System.out.println(" Correct !!");
				correctAnsCount++;
			} else {
				System.out.println(" Wrong (X) ");
				wrongAnsCount++;
			}
		}
		
		System.out.println();
		System.out.println("========== Result =========");
		System.out.println(" Total Questions : " +qList.size());
		System.out.println(" Correct Answered Questions : " + correctAnsCount);
		System.out.println(" Wrong Answered Questions : " + wrongAnsCount);
		System.out.println(" Percentage : "+(100*correctAnsCount)/qList.size());
	}
}


