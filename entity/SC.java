package entity;

public class SC implements IEntity {
	private String studentNo;  //ѧ��ѧ��
	private String courseNo;   //�γ̱��
	private int grade;         //�γ̳ɼ�
	
	//ѧ��ѧ��
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	//�γ̱��
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	//�γ̳ɼ�
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
