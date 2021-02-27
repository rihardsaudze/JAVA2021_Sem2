package model;

import utils.DataVerification;

public class Student {
	//1. variables
	private long st_ID;
	private String name;
	private String surname;
	private static long idCounter = 10000;
	
	//2. get and set
	public String getName() {
		return name;
	}
	
	public long getSt_ID() {
		return st_ID;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSt_ID() {
		this.st_ID = idCounter++;
	}
	
	public void setName(String name) {
		if (name != null) {
			this.name = DataVerification.nameAndSurnameVerification(name);
		} else {
			this.name = "";
		}
		//this.name = (name != null)?DataVerification.nameAndSurnameVerification(name):"";
	}
	
	public void setSurname(String surname) {
		if (surname != null) {
			this.surname = DataVerification.nameAndSurnameVerification(surname);
		} else {
			this.surname = "";
		}
		//this.surname = (surname != null)?DataVerification.nameAndSurnameVerification(surname):"";
	}
	
	//3. constructors
	public Student() {
		setSt_ID();
		name = "";
		surname = "";
	}
	
	public Student(String name, String surname, DegreeType degree) {
		setSt_ID();
		setName(name);
		setSurname(surname);
	}
	
	//4. toString
	public String toString() {
		return st_ID + ":" + name + " " + surname;
	}
	
	//5. other functions
}
