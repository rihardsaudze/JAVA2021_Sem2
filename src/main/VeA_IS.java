package main;
import java.util.ArrayList;
import model.*;

public class VeA_IS {
	private static ArrayList<Professor> profList = new ArrayList<>();
	private static ArrayList<Student> studList = new ArrayList<>();
	private static ArrayList<Course> courList = new ArrayList<>();
	private static ArrayList<Grade> gradList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Professor testProf = new Professor("Karina", "Šķirmante", DegreeType.Mg);	//Professors
		profList.add(testProf);
		testProf = new Professor("Mārcis", "Donerblics", DegreeType.PhD);
		profList.add(testProf);
		
		Student testStud = new Student("Rihards", "Audze", DegreeType.Bsc);			//Students
		studList.add(testStud);
		testStud = new Student("Emīls", "Vēveris", DegreeType.Bsc);
		studList.add(testStud);
		testStud = new Student("Andrejs", "Dzelme", DegreeType.Bsc);
		studList.add(testStud);
		
		Course testCour = new Course("OOP II", (byte)4, profList.get(0));					//Courses
		courList.add(testCour);
		testCour = new Course("IPTI", (byte)2, profList.get(1));
		courList.add(testCour);

		Grade testGrad = new Grade((byte)5, studList.get(0), courList.get(0));			//Rihards' grades
		gradList.add(testGrad);
		testGrad = new Grade((byte)2, studList.get(0), courList.get(0));
		gradList.add(testGrad);
		testGrad = new Grade((byte)9, studList.get(0), courList.get(0));
		gradList.add(testGrad);
		testGrad = new Grade((byte)6, studList.get(0), courList.get(1));
		gradList.add(testGrad);
		testGrad = new Grade((byte)7, studList.get(0), courList.get(1));
		gradList.add(testGrad);
		
		testGrad = new Grade((byte)9, studList.get(1), courList.get(0));					//Emīls' grades
		gradList.add(testGrad);
		testGrad = new Grade((byte)10, studList.get(1), courList.get(0));
		gradList.add(testGrad);
		testGrad = new Grade((byte)8, studList.get(1), courList.get(1));
		gradList.add(testGrad);
		testGrad = new Grade((byte)5, studList.get(1), courList.get(1));
		gradList.add(testGrad);
		testGrad = new Grade((byte)9, studList.get(1), courList.get(1));
		gradList.add(testGrad);
		
		testGrad = new Grade((byte)9, studList.get(2), courList.get(0));					//Andrejs' grades
		gradList.add(testGrad);
		testGrad = new Grade((byte)9, studList.get(2), courList.get(1));
		gradList.add(testGrad);
		testGrad = new Grade((byte)9, studList.get(2), courList.get(1));
		gradList.add(testGrad);
		testGrad = new Grade((byte)8, studList.get(2), courList.get(0));
		gradList.add(testGrad);
		testGrad = new Grade((byte)10, studList.get(2), courList.get(1));
		gradList.add(testGrad);
		
		System.out.println("" + testProf.toString());
		System.out.println("" + testStud.toString());
		System.out.println("" + testCour.toString());
		System.out.println("" + testGrad.toString());

		System.out.println("Riharda vidējā atzīme: " + calcAverageStudentGrade(studList.get(0)));
		System.out.println("Riharda vidējā svērtā atzīme: " + calcAverageStudentGradeCP(studList.get(0)));
		System.out.println("Emīla vidējā atzīme: " + calcAverageStudentGrade(studList.get(1)));
		System.out.println("Emīla vidējā svērtā atzīme: " + calcAverageStudentGradeCP(studList.get(1)));
		System.out.println("Andreja vidējā atzīme: " + calcAverageStudentGrade(studList.get(2)));
		System.out.println("Andreja vidējā svērtā atzīme: " + calcAverageStudentGradeCP(studList.get(2)));
		
		System.out.println("Vidējā atzīme OOP II: " + calcAverageGrade(courList.get(0)));

		System.out.println("Profesora NR1 pasniegto kursu skaits: " + profCourseCount(profList.get(0)));
		
		System.out.println("Studentu vidējo atzīmju saraksts: ");
		printAverageStudentGradeList();
	}
	
	public static float calcAverageStudentGrade(Student student) {
		float average = 0;
		int gradeCount = 0;
		for (int i = 0; i < gradList.size(); i++) {
			Student temp = gradList.get(i).getStudent();
			if (temp == student) {
				average += gradList.get(i).getValue();
				gradeCount++;
			}
		}
		return average / gradeCount;
	}
	
	public static float calcAverageStudentGradeCP(Student student) {
		int creditPointsTotal = 0, gradeCount = 0;
		float average = 0, averageTotal = 0;
		for (int i = 0; i < courList.size(); i++) {				//calculate total amount of credit points from all courses
			creditPointsTotal += courList.get(i).getCreditPoints();
		}
		
		for (Course course : courList) {						//iterates through all courses
			for (int i = 0; i < gradList.size(); i++) {			//iterates through all grades
				if (gradList.get(i).getStudent() == student && gradList.get(i).getCourse() == course) {		//if grade matches specified student and course
					average += gradList.get(i).getValue();
					gradeCount++;
				}
			}
			average = (average / gradeCount) * ((float)course.getCreditPoints() / (float)creditPointsTotal);	//calculates average based on credit points in course
			averageTotal += average;
			average = 0;
			gradeCount = 0;
		}
		return averageTotal;
	}
	
	public static float calcAverageGrade(Course course) {
		float average = 0;
		int gradeCount = 0;
		for (int i = 0; i < gradList.size(); i++) {
			if (gradList.get(i).getCourse() == course) {
				average += gradList.get(i).getValue();
				gradeCount++;
			}
		}
		return average / gradeCount;
	}
	
	public static int profCourseCount(Professor prof) {
		int courseCount = 0;
		for (int i = 0; i < courList.size(); i++) {
			if (courList.get(i).getProfessor() == prof) {
				courseCount++;
			}
		}
		return courseCount;
	}
	
	public static void printAverageStudentGradeList() {
		int n = studList.size();	//bubblesort vars
		float tempGrade = 0;		//
		String tempName = "";		//

		String names[] = new String[n];
		float grades[] = new float[n];
        
		for (int i=0; i < n; i++) {
			names[i] = "" + studList.get(i).getName() + " " + studList.get(i).getSurname();
			grades[i] = calcAverageStudentGrade(studList.get(i));
		}
		
		for(int i=0; i < n; i++){  				//bubblesort
			for(int j=1; j < (n-i); j++){  
				if(grades[j-1] < grades[j]){  
					tempGrade = grades[j-1];	//swap grades  
		            grades[j-1] = grades[j];  	//
		            grades[j] = tempGrade;  	//
		            
		            tempName = names[j-1];		//swap names
		            names[j-1] = names[j];		//
		            names[j] = tempName;		//
		        }           
			}  
		}
		for (int i = 0; i < n; i++) {
			System.out.println(names[i] + ", " + grades[i]);
		}
	}
}
