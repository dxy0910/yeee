package entity;

public class SC implements IEntity {
	private String studentNo;  //学生学号
	private String courseNo;   //课程编号
	private int grade;         //课程成绩
	
	//学生学号
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	//课程编号
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	//课程成绩
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
