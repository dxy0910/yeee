package entity;

public class Student implements IEntity {
	private String studentNo;           //ѧ��
	private String studentName;         //����
	private String studentGender;       //�Ա�
	private int studentAge;				//����
	private String studentDepartment;   //Ժϵ
	private String studentPassword;     //����
	
	//ѧ��	
	public String getStudentNo() {
		//get�ǵõ����ݣ�˭����˭�õ�
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		//��ֵ   //ע��ʱ�������
		this.studentNo = studentNo;
	}
	//����	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	//�Ա�
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	//����
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	//Ժϵ
	public String getStudentDepartment() {
		return studentDepartment;
	}
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	//����
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
}
