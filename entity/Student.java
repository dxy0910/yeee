package entity;

public class Student implements IEntity {
	private String studentNo;           //学号
	private String studentName;         //姓名
	private String studentGender;       //性别
	private int studentAge;				//年龄
	private String studentDepartment;   //院系
	private String studentPassword;     //密码
	
	//学号	
	public String getStudentNo() {
		//get是得到数据，谁调用谁得到
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		//赋值   //注册时常会调用
		this.studentNo = studentNo;
	}
	//姓名	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	//性别
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	//年龄
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	//院系
	public String getStudentDepartment() {
		return studentDepartment;
	}
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	//密码
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
}
