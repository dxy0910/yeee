package view;

import java.util.*;

import biz.*;
import dao.*;
import entity.*;

public class RegisterUI {  
	//用户注册
	public static void show1() throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("===已进入学生用户注册界面！===");
		System.out.println("请输入学号：");
		String studentNo = scanner.nextLine();
		System.out.println("请输入姓名：");
		String studentName = scanner.nextLine();
		System.out.println("请输入性别：");
		String studentGender = scanner.nextLine();
		System.out.println("请输入年龄：");
		int studentAge = Integer.parseInt(scanner.nextLine());		
		System.out.println("请输入院系：");
		String studentDepartment = scanner.nextLine();
		System.out.println("请输入密码：");
		String firstPassword = scanner.nextLine();
		System.out.println("请再次输入密码：");
		String secondPassword = scanner.nextLine();
		
		StudentBiz sc = new StudentBiz();//调用学生数据库存入注册学生信息
		sc.register(studentNo,
			    	studentName,
			    	studentGender,//不能正常调用是为什么？
			    	studentAge,
			    	studentDepartment,
			    	firstPassword,
			    	secondPassword);
	}
	
	public static void show2() throws Exception {
		//课程注册
		Scanner scanner = new Scanner(System.in);
		System.out.println("===已进入课程信息注册界面！===");
		System.out.println("请输入课程编号：");
		String courseNo = scanner.nextLine();
		System.out.println("请输入课程名字：");
		String courseName = scanner.nextLine();
		System.out.println("请输入课程成绩：");
		int courseGender = 0;
		
		CourseBiz sc = new CourseBiz();//调用学生数据库存入注册学生信息
		sc.register(courseNo,
				    courseName,
				    courseGender);
		
	}
		
}
