package view;

import java.util.*;

import biz.*;
import dao.*;
import entity.*;

public class RegisterUI {  
	//�û�ע��
	public static void show1() throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("===�ѽ���ѧ���û�ע����棡===");
		System.out.println("������ѧ�ţ�");
		String studentNo = scanner.nextLine();
		System.out.println("������������");
		String studentName = scanner.nextLine();
		System.out.println("�������Ա�");
		String studentGender = scanner.nextLine();
		System.out.println("���������䣺");
		int studentAge = Integer.parseInt(scanner.nextLine());		
		System.out.println("������Ժϵ��");
		String studentDepartment = scanner.nextLine();
		System.out.println("���������룺");
		String firstPassword = scanner.nextLine();
		System.out.println("���ٴ��������룺");
		String secondPassword = scanner.nextLine();
		
		StudentBiz sc = new StudentBiz();//����ѧ�����ݿ����ע��ѧ����Ϣ
		sc.register(studentNo,
			    	studentName,
			    	studentGender,//��������������Ϊʲô��
			    	studentAge,
			    	studentDepartment,
			    	firstPassword,
			    	secondPassword);
	}
	
	public static void show2() throws Exception {
		//�γ�ע��
		Scanner scanner = new Scanner(System.in);
		System.out.println("===�ѽ���γ���Ϣע����棡===");
		System.out.println("������γ̱�ţ�");
		String courseNo = scanner.nextLine();
		System.out.println("������γ����֣�");
		String courseName = scanner.nextLine();
		System.out.println("������γ̳ɼ���");
		int courseGender = 0;
		
		CourseBiz sc = new CourseBiz();//����ѧ�����ݿ����ע��ѧ����Ϣ
		sc.register(courseNo,
				    courseName,
				    courseGender);
		
	}
		
}
