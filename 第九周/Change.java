package 第九周;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Change {
	public static void change() {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入您要修改学生学号：");
		String num=sc.nextLine();
		Iterator it=Main.list.iterator();
		while(it.hasNext()) {
			Object obj=it.next();
			Student stu1=(Student)obj;
			if(num.equals(stu1.getStudentNum())) {
				System.out.println("请输入学生学号：");
				String Num=sc.nextLine();
				stu1.setStudentNum(Num);
				System.out.println("请输入学生姓名：");
				String name=sc.nextLine();
				stu1.setStudentName(name);
				System.out.println("请输入学生性别：");
				String gender=sc.nextLine();
				stu1.setStudentgender(gender);
	         }
		}	
  }
}
