package view;

import java.util.Scanner;

import biz.StudentBiz;

public class LoginUI {	
	//�û���¼����
	public static void show() throws Exception {
		Scanner scanner = new Scanner(System.in);  //����һ��������
		StudentBiz studentBiz = new StudentBiz();  //����һ��studentBiz��
		String studentName;                        //ѧ��ѧ��
		String studentPassword;                    //ѧ������
		System.out.println("��ѡ���¼��ʽ:1.ѧ�� 2.����Ա");
		String option = scanner.nextLine();  //����ѡ��������
		String guanliName;
		String guanliPassword;
		switch (option) {
		case "1":   //ѧ����¼
			System.out.println("�Ƿ���Ҫע�᣿��yes�����ߣ�no��");
			String a = scanner.nextLine();
			if(a.equals("yes")){
				RegisterUI.show1();
			}
			else {
				System.out.println("������ѧ�ţ�");       
				studentName = scanner.nextLine();          //����
				System.out.println("���������룺");
				studentPassword = scanner.nextLine();      //����
				studentBiz.login(studentName, studentPassword);  //���õ�¼
			}
			break;
		case "2":   //����Ա��¼
			System.out.println("����������˺ţ�");       
			guanliName = scanner.nextLine();          //����
			System.out.println("������������룺");
			guanliPassword = scanner.nextLine();      //����
			studentBiz.logina(guanliName, guanliPassword);  //���õ�¼
			break;
		default:
			System.out.println("��������������������룡");
		}
	}
}
