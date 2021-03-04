package model;

public class Course {
	private long c_ID;
	private String title;
	private byte creditPoints;
	private Professor professor;
	private static long idCounter = 100000;
	
	public long getC_ID() {
		return c_ID;
	}
	
	public void setC_ID() {
		this.c_ID = idCounter++;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		if (title != null) {
			this.title = title;
		} else {
			this.title = "";
		}
	}
	
	public int getCreditPoints() {
		return creditPoints;
	}
	
	public void setCreditPoints(byte creditPoints) {
		if (creditPoints > 0 && creditPoints <= 20) {
			this.creditPoints = creditPoints;
		} else {
			this.creditPoints = 4;
		}
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		if (professor != null) {
			this.professor = professor;
		} else {
			this.professor = new Professor();
		}
	}
	
	public Course() {
		setC_ID();
		this.title = "";
		this.creditPoints = 4;
		this.professor = new Professor();
	}
	
	public Course(String title, byte creditPoints, Professor professor) {
		setC_ID();
		setTitle(title);
		setCreditPoints(creditPoints);
		setProfessor(professor);
	}
	
	public String toString() {
		return c_ID + ":" + title + ", " + professor.getName() + " " + professor.getSurname() + ", " + creditPoints + "KP";
	}
	
}
