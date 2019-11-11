package 第九周;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int count;
	static ArrayList list=new ArrayList();
	public static void main(String[] args) throws InterruptedException 
	 {
		
		Student stu=new Student();
		Scanner sc=new Scanner(System.in);
		System.out.println("欢迎使用学生管理系统!");
		Thread.sleep(200);
		while(true) {
		System.out.println("1-添加学生");
		System.out.println("2-删除学生");
		System.out.println("3-修改信息");
		
		System.out.println("请输入你的选择：");
		int choice=sc.nextInt();
		if(choice==4)
			break;
		else {
			switch(choice) {
			case 1:Add.add();break;
			case 2:Delete.delete();break;
			case 3:Change.change();break;
			}
			
		}
		
		}
	}

}
