package biz;

import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import view.LoginUI;
import view.MainUI;

//ѧ����Ϣ���ݷ���
public class StudentBiz {
	StudentDao studentDao;      //����ѧ�����ݿ�����
	private Student student;    //����˽��ѧ������
	
	//�û���¼ ������LoginUI���ã�
	public void login(String studentNo, String studentPassword) throws Exception  {
		studentDao = StudentDao.getInstance();                 //���ѧ����ʵ������
		student = (Student) studentDao.getEntity(studentNo);   //�õõ���ѧ�Ž���ѧ��ʵ��
		if (student == null) {
			System.out.println("��Ǹ���û������ڣ����������룡");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("��¼�ɹ�");
			MainUI.show1(studentPassword, studentPassword);   //������ҳ����
		} else {
			System.out.println("���벻��ȷ");
			//MainUI.show();   //������ҳ����
			return;
		}
	}
	
	//����Ա��¼ ������LoginUI���ã�
	public void logina(String guanliNo, String guanliPassword) throws Exception {
		if (guanliNo.equals("123456") && guanliPassword.equals("123456")) {
			System.out.println("��¼�ɹ�");
			MainUI.show2(guanliPassword, guanliPassword);   //������ҳ����
		} else {
			System.out.println("�˺Ż����벻��ȷ");
			return;
		}
	}
	//�޸�����
    public void modifyPassword() throws Exception {	 
   		 student = new Student();
   		 studentDao = StudentDao.getInstance();
   		 studentDao.update();  //����ɾ��
//   		 MainUI.show1();       //
    }
	//ע��ѧ����Ϣ��ҵ���߼�ʵ��
	public void register(String studentNo, 		   //ѧ��
						String studentName, 	   //����
						String studentGender,      //�Ա�
						int studentAge,            //����
						String studentDepartment,  //Ժϵ
						String firstPassword,      //��һ������
						String secondPassword) throws Exception {   //�ڶ�������
		
		if(firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentGender(studentGender);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			studentDao = StudentDao.getInstance();
			
			studentDao.insert(student); // ע��
			System.out.println("ע��ɹ���");
			LoginUI.show();
		}else {
			System.out.println("�������벻ͬ������������");
			return ;
		}
	}
	
}
