package view;

import java.util.Scanner;
import dao.*;

public class Guanlistudent {
	
	public static void show() throws Exception{
		//��¼�ɹ������MainUI���빦��ѡ��
		System.out.println("================��ӭʹ��ѧ����Ϣ����ϵͳ=========");
		System.out.println("����Ա����");
		System.out.println("1-���ѧ����Ϣ��2-ɾ��ѧ����Ϣ��3-�޸�ĳѧ����Ϣ��4-�鿴����ѧ����Ϣ��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		StudentDao studentdao = StudentDao.getInstance();
		String option = scanner.nextLine();  //����ѡ��������
		switch (option) {
		case "1":   //���ѧ����Ϣ
			RegisterUI.show1();
			break;
		case "2":   //ɾ��ѧ����Ϣ
			studentdao.delete();
			break;
		case "3":   //�޸�ĳѧ����Ϣ
			studentdao.update();
			break;
		case "4":   //�鿴����ѧ����Ϣ
//			StudentDao.writer(file, students);
			break;
		case "0":   //�˳�
			break;
		default:
			System.out.println("��������������������룡");
		}
	}
	
	public static void main(String[] args) {
		
	}

}
