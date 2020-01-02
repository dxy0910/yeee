package view;

import java.util.Scanner;

import biz.StudentBiz;

public class LoginUI {	
	//用户登录界面
	public static void show() throws Exception {
		Scanner scanner = new Scanner(System.in);  //建立一个输入类
		StudentBiz studentBiz = new StudentBiz();  //建立一个studentBiz类
		String studentName;                        //学生学号
		String studentPassword;                    //学生密码
		System.out.println("请选择登录方式:1.学生 2.管理员");
		String option = scanner.nextLine();  //输入选择功能数字
		String guanliName;
		String guanliPassword;
		switch (option) {
		case "1":   //学生登录
			System.out.println("是否需要注册？（yes）或者（no）");
			String a = scanner.nextLine();
			if(a.equals("yes")){
				RegisterUI.show1();
			}
			else {
				System.out.println("请输入学号：");       
				studentName = scanner.nextLine();          //输入
				System.out.println("请输入密码：");
				studentPassword = scanner.nextLine();      //输入
				studentBiz.login(studentName, studentPassword);  //调用登录
			}
			break;
		case "2":   //管理员登录
			System.out.println("请输入管理账号：");       
			guanliName = scanner.nextLine();          //输入
			System.out.println("请输入管理密码：");
			guanliPassword = scanner.nextLine();      //输入
			studentBiz.logina(guanliName, guanliPassword);  //调用登录
			break;
		default:
			System.out.println("输入操作有误！请重新输入！");
		}
	}
}
