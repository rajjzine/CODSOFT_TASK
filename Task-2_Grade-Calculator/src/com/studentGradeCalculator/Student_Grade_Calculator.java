package com.studentGradeCalculator;

import java.util.Scanner;

public class Student_Grade_Calculator {
	public static void main(String[] args) {

		System.out.println("Details for calculate grade..!");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Roll-Number : ");
		int rollNo = sc.nextInt();

		System.out.println("Enter your name : ");
		String name = sc.next();

		System.out.println("Enter the marks of Mathematics : ");
		int mathematics = sc.nextInt();

		System.out.println("Enter the marks of Chemistry : ");
		int chemistry = sc.nextInt();

		System.out.println("Enter the marks of Biology : ");
		int biology = sc.nextInt();

		System.out.println("Enter the marks of History : ");
		int history = sc.nextInt();

		System.out.println("Enter the marks of Science : ");
		int science = sc.nextInt();

		System.out.println("Enter the marks of Economics : ");
		int economics = sc.nextInt();

		System.out.println("Enter the marks of Computer Science : ");
		int computer_science = sc.nextInt();

		System.out.println("Enter the marks of Accounting : ");
		int accounting = sc.nextInt();

		int total_marks = mathematics + chemistry + biology + history + science + economics + computer_science
				+ accounting;

		double average = total_marks / 8.0;
		String grade;

		if (average >= 90.00) {
			grade = "Your Grade is A (Excellent..!)";
		} else if (average < 90.00 && average >= 80.00) {
			grade = "Your Grade is B (Very Good..!) ";
		} else if (average < 80.00 && average >= 70.00) {
			grade = "Your Grade is C (Good..!)";
		} else if (average < 70.00 && average >= 60.00) {
			grade = "Your Grade is D (Satisfactory..!)";
		} else if (average < 60.00 && average >= 50.00) {
			grade = "Your Grade is E (Work Hard..!)";
		} else if (average < 50 && average >= 40) {
			grade = "Your Grade is F (Just Passed..!)";
		} else {
			grade = "(Failed..!)";

		}

		System.out.println("Your Name is : " + name);
		System.out.println("Your Marks is : " + total_marks);
		System.out.println("your Average or Percentage is : " + average);
		System.out.println("Your Grade is : " + grade);


	}
}
