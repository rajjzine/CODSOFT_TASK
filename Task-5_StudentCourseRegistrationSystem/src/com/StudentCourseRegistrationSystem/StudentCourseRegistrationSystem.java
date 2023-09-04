package com.StudentCourseRegistrationSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentCourseRegistrationSystem {
	public static void main(String[] args) {
		System.out.println("           Student Course Registration System    ");
		System.out.println("*********************************************************");
		List<Course> courses = new ArrayList<>();
		courses.add(new Course("MANC401", "Basic of Web Technology", "learn from basic of programming", 50,
				"Mon/Wed 10:00 AM - 11.30 AM", 50));
		courses.add(new Course("MANC402", "Mathematics", "learn from basic of programming", 40,
				"Tue/Tus 10:00 AM - 11.30 AM", 40));
		courses.add(new Course("MANC403", "Object Oriented Programming Using C++", "learn from basic of programming", 30,
				"Fri/Sat 10:00 AM - 11.30 AM", 30));
		courses.add(new Course("MANC404", "Constitution of India", "learn from basic of programming", 20,
				"Mon/Tue 12:00 AM - 1.30 AM", 20));
		courses.add(new Course("MANC405", "Yoga", "learn from basic of programming", 10,
				"Wed/Fri 08:00 AM - 09.00 AM", 10));

		List<Student> students = new ArrayList<>();
		students.add(new Student(101, "Dharmraj Zine"));
		students.add(new Student(102, "ABC XYZ"));

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n1. View available courses");
			System.out.println("2. Register for a course");
			System.out.println("3. Drop a course");
			System.out.println("4. Exit");
			System.out.println("Enter your choise: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\nAvailable Courses:");
				for (Course course : courses) {
					System.out.println(course);
					System.out.println("------------------------");
				}
				break;

			case 2:
				System.out.println("Enter student ID: ");
				int studentID = sc.nextInt();
				Student student = findStudent(students, studentID);
				if (student != null) {
					System.out.println("\nAvailable Courses:");
					for (int i = 0; i < courses.size(); i++) {
						System.out.println(i + 1 + ". " + courses.get(i).getTitle());
					}
					System.out.println("Select a course (1-" + courses.size() + "): ");
					int courseChoise = sc.nextInt() - 1;
					if (courseChoise >= 0 && courseChoise < courses.size()) {
						student.registerCourse(courses.get(courseChoise));
					} else {
						System.out.println("Invalid course selection.");
					}
				} else {
					System.out.println("Student not found.");
				}
				break;

			case 3:
				System.out.println("Enter student ID: ");
				int studentIDrop = sc.nextInt();
				Student studentDrop = findStudent(students, studentIDrop);
				if (studentDrop != null) {
					List<Course> studentCourses = studentDrop.getRegisteredCourses();
					if (!studentCourses.isEmpty()) {
						System.out.println("Registered Courses:");
						for (int i = 0; i < studentCourses.size(); i++) {
							System.out.println(i + 1 + ". " + studentCourses.get(i).getTitle());
						}
						System.out.println("select a course to drop (1-" + studentCourses.size() + "): ");
						int courseChoiseDrop = sc.nextInt() - 1;
						if (courseChoiseDrop >= 0 && courseChoiseDrop < studentCourses.size()) {
							studentDrop.removeCourse(studentCourses.get(courseChoiseDrop));
						} else {
							System.out.println("Invalid course selection.");
						}
					} else {
						System.out.println("No registered courses to drop.");
					}
				} else {
					System.out.println("Student not found.");
				}
				break;

			case 4:
				System.out.println("Exiting the system.");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}

	static Student findStudent(List<Student> students, int studentID) {
		for (Student student : students) {
			if (student.getStudentID() == studentID) {
				return student;
			}
		}
		return null;
	}
}

class Student {
	private int studentID;
	private String name;
	private List<Course> registeredCourses;

	public Student(int studentID, String name) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.registeredCourses = new ArrayList<>();
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getRegisteredCourses() {
		return registeredCourses;
	}

	public void setRegisteredCourses(List<Course> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}

	public void registerCourse(Course course) {
		if (course.registerStudent()) {
			registeredCourses.add(course);
			System.out.println("Course registered: " + course.getTitle());
		} else {
			System.out.println("Course is full: " + course.getTitle());
		}
	}

	public void removeCourse(Course course) {
		if (registeredCourses.contains(course)) {
			course.dropStudent();
			registeredCourses.remove(course);
			System.out.println("Course dropped: " + course.getTitle());
		} else {
			System.out.println("Course not found: " + course.getTitle());
		}
	}
}

class Course {
	private String code;
	private String title;
	private String description;
	private int capacity;
	private String schedule;
	private int availableSlots;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String code, String title, String description, int capacity, String schedule, int availableSlots) {
		super();
		this.code = code;
		this.title = title;
		this.description = description;
		this.capacity = capacity;
		this.schedule = schedule;
		this.availableSlots = availableSlots;
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getSchedule() {
		return schedule;
	}

	public int getAvailableSlots() {
		return availableSlots;
	}

	public boolean registerStudent() {
		if (availableSlots > 0) {
			availableSlots--;
			return true;
		}
		return false;
	}

	public void dropStudent() {
		if (availableSlots < capacity) {
			availableSlots++;
		}
	}

	@Override
	public String toString() {
		return "Course code : " + code + "\n" + "Title : " + title + "\n" + "Description : " + description + "\n"
				+ "Available Slots : " + availableSlots + "/" + capacity + "\n" + "Schedule : " + schedule;
	}

}