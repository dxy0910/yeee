package view;

import java.util.Scanner;

import dao.CourseDao;

public class Guanlicourse {
	
	public static void show() throws Exception{
		//��¼�ɹ������MainUI���빦��ѡ��
		System.out.println("=============��ӭʹ��ѧ����Ϣ����ϵͳ============");
		System.out.println("����Ա����");
		System.out.println("1-��ӿγ���Ϣ��2-ɾ���γ���Ϣ��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		CourseDao coursedao = CourseDao.getInstance();		
		String option = scanner.nextLine();  //����ѡ��������
		switch (option) {
		case "1":   //��ӿγ���Ϣ
			RegisterUI.show2();
			break;
		case "2":   //ɾ���γ���Ϣ
			coursedao.delete();
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
