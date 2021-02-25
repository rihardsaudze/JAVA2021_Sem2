package model;

import utils.DataVerification;

public class Professor {
	//1. variables
	private long p_ID;
	private String name;
	private String surname;
	private DegreeType degree;
	private static long idCounter = 0;
	
	
	//2. get and set
	public String getName() {
		return name;
	}
	
	public long getP_ID() {
		return p_ID;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public DegreeType getDegree() {
		return degree;
	}
	
	public void setP_ID() {
		this.p_ID = idCounter++;
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
	
	public void setDegree(DegreeType degree) {
		if (degree != null) {
			this.degree = degree;
		} else {
			this.degree = DegreeType.Bsc;
		}
	}
	
	//3. constructors
	public Professor() {
		setP_ID();
		name = "";
		surname = "";
		degree = DegreeType.Bsc;
	}
	
	public Professor(String name, String surname, DegreeType degree) {
		setP_ID();
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}
	
	//4. toString
	public String toString() {
		return p_ID + ":" + name + " " + surname + "," + degree;
	}
	
	//5. other functions
}
