package model;

import utils.DataVerification;

public class Grade {
	private long g_ID;
	private byte value;
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
	
	public void setValue(byte value) {
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
		if (student != null) {
			this.student = student;
		} else {
			this.student = new Student();
		}
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		if (course != null) {
			this.course = course;
		} else {
			this.course = new Course();
		}
	}
	
	public Grade() {
		setG_ID();
		this.value = 0;
		this.student = new Student();
		this.course = new Course();
	}
	
	public Grade(byte value, Student student, Course course) {
		setG_ID();
		setValue(value);
		setStudent(student);
		setCourse(course);
	}
	
	public String toString() {
		return g_ID + ":" + course.getTitle() + ", " + student.getName() + " " + student.getSurname() + ", " + value;
	}
}
