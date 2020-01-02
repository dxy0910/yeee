package biz;

import java.util.*;
import dao.*;
import entity.*;
import view.Guanlisc;
import view.*;

public class SCBiz {
	
	private SC sc = new SC();
	SCDao scdao;
	CourseDao coursedao;
	HashMap<String, IEntity> hash = new HashMap<String,IEntity>();
	StudentDao studentdao;
  
    public void selectioncourse(String studentNo,String studentPassword) throws Exception {
		    
    	studentdao = StudentDao.getInstance();//建立实例化对象
    	Student student = (Student)studentdao.getEntity(studentNo);
//    	通过学好查找，将其学生信息存入student
    	if( student.getStudentPassword().equals(studentPassword) ) {
    		System.out.println("课程信息");
		    coursedao = CourseDao.getInstance();  //实例化课程
		    hash = coursedao.getAllEntities();    //所有的课程存给hash
		    scdao = SCDao.getInstance();
		    
		    Set keySet = hash.keySet();  //把hash的键作为一个集合给keyset
	   	    Iterator in = keySet.iterator(); //迭代器（Iterator）
	   		
	   	    while(in.hasNext()){         //检查序列中是否还有元素。
	   			Object key = in.next();  //获得序列中的下一个元素。
	   			Course cou = (Course)hash.get(key);         //遍历输出所有课程信息
	   		    System.out.println( cou.getCourseNo()+","+  //并输出
	   		    					cou.getCourseName()+","+
	   		    					cou.getCourseGrade()  );	
	   		}
	   	    
	   		Scanner scanner = new Scanner(System.in);
	   		System.out.println("请输入课程号：");
			String courseNo = scanner.nextLine();
			
			if(hash.containsKey(courseNo) == true) {
				
				System.out.println("请输入该课程的成绩：");
				int grade = scanner.nextInt();
				
				sc.setStudentNo(studentNo);
				sc.setCourseNo(courseNo);
				sc.setGrade(grade);
				scdao.insert(sc);//添加选课
				System.out.println("选课登记成功!");
			}
			else{
			   System.err.println("选课登记失败!");
			}  
    	}
    	else {
    		System.out.println("数据库无此学生信息！请重新输入");
    		Guanlisc.show();
    	}
//		 StudentUI.show(studentNo,studentPassword);
    }	
}
