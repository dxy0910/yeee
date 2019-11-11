package 第九周;

import java.util.*;

public class Delete {
	public static void delete() throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入要删除的学生学号：");
		String num=sc.nextLine();
		Iterator it=Main.list.iterator();
		for(int i=0;i<Main.list.size();i++){
			Object obj=it.next();
			Student stu1=(Student)obj;

			//System.out.println(stu1.getStudentNum());
			if(num.equals(stu1.getStudentNum())) {
				System.out.println("您要删除学生信息如下：");
				System.out.println(stu1.toString());
				Thread.sleep(1000);
				System.err.println("确认删除此人吗？\nYes   No");
				String hd=sc.nextLine();
				if(hd.equals("Yes")) {
					Main.list.remove(obj);
					System.out.println("已删除");
				}
			}
		
		}
		
	}

}
