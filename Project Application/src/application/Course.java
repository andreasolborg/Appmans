package application;

public class Course { // i denne klassen lager vi et Course objekt, som inneholder navn på faget og karakteren
	private String courseName;
	private String grade;
	
	public Course(String courseName, String grade) {
		this.courseName = courseName;
		this.grade = grade;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


	public static void main(String[] args) {

	}
}
