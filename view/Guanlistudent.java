package view;

import java.util.Scanner;
import dao.*;

public class Guanlistudent {
	
	public static void show() throws Exception{
		//登录成功后进入MainUI进入功能选择
		System.out.println("================欢迎使用学生信息管理系统=========");
		System.out.println("管理员界面");
		System.out.println("1-添加学生信息；2-删除学生信息；3-修改某学生信息；4-查看所有学生信息；0-退出");
		Scanner scanner = new Scanner(System.in);
		StudentDao studentdao = StudentDao.getInstance();
		String option = scanner.nextLine();  //输入选择功能数字
		switch (option) {
		case "1":   //添加学生信息
			RegisterUI.show1();
			break;
		case "2":   //删除学生信息
			studentdao.delete();
			break;
		case "3":   //修改某学生信息
			studentdao.update();
			break;
		case "4":   //查看所有学生信息
//			StudentDao.writer(file, students);
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
