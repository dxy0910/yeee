package entity;

public class Course implements IEntity {
	private String courseNo;      //�γ̱��
	private String courseName;    //�γ�����
	private int courseGrade;      //�γ̳ɼ�
	
	//�γ̱��
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	//�γ�����
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	//�γ̳ɼ�
	public int getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(int courseGrade) {
		this.courseGrade = courseGrade;
	}
}
