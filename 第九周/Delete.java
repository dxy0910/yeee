package �ھ���;

import java.util.*;

public class Delete {
	public static void delete() throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		System.out.println("������Ҫɾ����ѧ��ѧ�ţ�");
		String num=sc.nextLine();
		Iterator it=Main.list.iterator();
		for(int i=0;i<Main.list.size();i++){
			Object obj=it.next();
			Student stu1=(Student)obj;

			//System.out.println(stu1.getStudentNum());
			if(num.equals(stu1.getStudentNum())) {
				System.out.println("��Ҫɾ��ѧ����Ϣ���£�");
				System.out.println(stu1.toString());
				Thread.sleep(1000);
				System.err.println("ȷ��ɾ��������\nYes   No");
				String hd=sc.nextLine();
				if(hd.equals("Yes")) {
					Main.list.remove(obj);
					System.out.println("��ɾ��");
				}
			}
		
		}
		
	}

}
