package view;

import java.util.Scanner;

import dao.SCDao;

public class Guanlisc {
	public static void show() throws Exception{
		//登录成功后进入MainUI进入功能选择
		System.out.println("================欢迎使用学生信息管理系统=========");
		System.out.println("管理员界面");
		System.out.println("1-删除选课信息；2-修改选课信息；0-退出");
		Scanner scanner = new Scanner(System.in);
		SCDao scdao = SCDao.getInstance();
		
		String option = scanner.nextLine();  //输入选择功能数字
		switch (option) {
		case "1":   //删除选课信息
			scdao.delete();
			break;
		case "2":   //修改选课信息
			scdao.update();
			break;
		case "0":   //退出
			break;
		default:
			System.out.println("输入操作有误！请重新输入！");
		}
		System.out.println("========感谢使用学生信息管理系统=======");
	}
	
	public static void main(String[] args) {
		
	}

}
