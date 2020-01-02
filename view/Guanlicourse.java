package view;

import java.util.Scanner;

import dao.CourseDao;

public class Guanlicourse {
	
	public static void show() throws Exception{
		//登录成功后进入MainUI进入功能选择
		System.out.println("=============欢迎使用学生信息管理系统============");
		System.out.println("管理员界面");
		System.out.println("1-添加课程信息；2-删除课程信息；0-退出");
		Scanner scanner = new Scanner(System.in);
		CourseDao coursedao = CourseDao.getInstance();		
		String option = scanner.nextLine();  //输入选择功能数字
		switch (option) {
		case "1":   //添加课程信息
			RegisterUI.show2();
			break;
		case "2":   //删除课程信息
			coursedao.delete();
			break;
		case "0":   //退出
			break;
		default:
			System.out.println("输入操作有误！请重新输入！");
		}
	}
	
	public static void main(String[] args) {
		
	}

}
