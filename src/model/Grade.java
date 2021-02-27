package model;

import utils.DataVerification;

public class Grade {
	private long g_ID;
	private int value;
	private Student student;
	private Course course;
	private static long idCounter = 200000;
	
	public long getG_ID() {
		return g_ID;
	}
	
	public void setG_ID() {
		this.g_ID = idCounter++;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		if (DataVerification.isValidGrade(value)) {
			this.value = value;		
		} else {
			this.value = 0;
		}
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Grade() {
		setG_ID();
		value = 0;
		student = new Student();
		course = new Course();
	}
	
	public Grade(int value, Student student, Course course) {
		setG_ID();
		setValue(value);
		setStudent(student);
		setCourse(course);
	}
	
	public String toString() {
		return g_ID + ":" + course.getTitle() + ", " + student.getName() + " " + student.getSurname() + ", " + value;
	}
}
