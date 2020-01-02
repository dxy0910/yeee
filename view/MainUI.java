package view;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import dao.SCDao;
import dao.StudentDao;
import entity.IEntity;

public class MainUI {
	
	public static void show1(String studentNo,String studentPassword) throws Exception{
		//登录成功后进入MainUI进入功能选择
		System.out.println("================欢迎使用学生信息管理系统=========");
		System.out.println("学生界面");
		System.out.println("1-修改密码；2-选课；3-退选；4-查看个人信息；5-查看选课信息；0-退出");
		Scanner scanner = new Scanner(System.in);
		HashMap<String, IEntity> hash = new HashMap<String,IEntity>();
		StudentDao studentDao = StudentDao.getInstance();
		SCDao scDao = SCDao.getInstance();
	    hash = studentDao.getAllEntities();  //sc的
		String option = scanner.nextLine();  //输入选择功能数字
		switch (option) {
		case "1":   //修改密码
			ModifyPasswordUI.show();
			break;
		case "2":   //选课
			CourseSelection.show1(studentNo, studentPassword);
			break;
		case "3":   //退选
			CourseSelection.show2(studentNo, studentPassword);
			break;
		case "4":   //查看个人信息
			studentDao.studentid(studentNo);
			break;
		case "5":   //查看选课信息
			scDao.sourseid(studentNo);
			break;
		case "0":   //退出
			break;
		default:
			System.out.println("输入操作有误！请重新输入！");
		}
//		System.out.println("========感谢使用学生信息管理系统=======");
	}
	
	public static void show2(String studentNo,String studentPassword) throws Exception{
		//登录成功后进入MainUI进入功能选择
		System.out.println("================欢迎使用学生信息管理系统=========");
		System.out.println("管理员界面");
		System.out.println("1-学生管理；2-课程管理；3-学生选课管理；0-退出");
		
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();  //输入选择功能数字
		
		switch (option) {
		case "1":   //学生信息的增删改查
			Guanlistudent.show();
			break;
		case "2":   //课程信息的增删改查
			Guanlicourse.show();
			break;
		case "3":   //学生选课信息的增删改查
			Guanlisc.show();
			break;
		case "0":   //退出
			break;
		default:
			System.out.println("输入操作有误！请重新输入！");
		}
//		System.out.println("========感谢使用学生信息管理系统=======");
	}
	
}
