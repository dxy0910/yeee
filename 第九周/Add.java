package 第九周;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Add {
	static int count;
	public static void add() {
		Student stu=new Student();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入学生学号：");
		String num=sc.nextLine();
		stu.setStudentNum(num);
		System.out.println("请输入学生姓名：");
		String name=sc.nextLine();
		stu.setStudentName(name);
		System.out.println("请输入学生性别：");
		String gender=sc.nextLine();
		stu.setStudentgender(gender);
		Main.list.add(count,stu);
		count++;
		
     }
}
