package model;

public class Course {
	private long c_ID;
	private String title;
	private int creditPoints;
	private Professor professor;
	private static long idCounter = 100000;
	
	public long getC_ID() {
		return c_ID;
	}
	
	public void setC_ID() {
		this.c_ID = idCounter++;;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getCreditPoints() {
		return creditPoints;
	}
	
	public void setCreditPoints(int creditPoints) {
		this.creditPoints = creditPoints;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Course() {
		setC_ID();
		title = "";
		creditPoints = 0;
		professor = new Professor();
	}
	
	public Course(String title, int creditPoints, Professor professor) {
		setC_ID();
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfessor(professor);
	}
	
	public String toString() {
		return c_ID + ":" + title + ", " + professor.getName() + " " + professor.getSurname() + ", " + creditPoints;
	}
	
}
