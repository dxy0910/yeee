package view;

import java.util.Scanner;

import dao.SCDao;

public class Guanlisc {
	public static void show() throws Exception{
		//��¼�ɹ������MainUI���빦��ѡ��
		System.out.println("================��ӭʹ��ѧ����Ϣ����ϵͳ=========");
		System.out.println("����Ա����");
		System.out.println("1-ɾ��ѡ����Ϣ��2-�޸�ѡ����Ϣ��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		SCDao scdao = SCDao.getInstance();
		
		String option = scanner.nextLine();  //����ѡ��������
		switch (option) {
		case "1":   //ɾ��ѡ����Ϣ
			scdao.delete();
			break;
		case "2":   //�޸�ѡ����Ϣ
			scdao.update();
			break;
		case "0":   //�˳�
			break;
		default:
			System.out.println("��������������������룡");
		}
		System.out.println("========��лʹ��ѧ����Ϣ����ϵͳ=======");
	}
	
	public static void main(String[] args) {
		
	}

}
