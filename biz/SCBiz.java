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
		    
    	studentdao = StudentDao.getInstance();//����ʵ��������
    	Student student = (Student)studentdao.getEntity(studentNo);
//    	ͨ��ѧ�ò��ң�����ѧ����Ϣ����student
    	if( student.getStudentPassword().equals(studentPassword) ) {
    		System.out.println("�γ���Ϣ");
		    coursedao = CourseDao.getInstance();  //ʵ�����γ�
		    hash = coursedao.getAllEntities();    //���еĿγ̴��hash
		    scdao = SCDao.getInstance();
		    
		    Set keySet = hash.keySet();  //��hash�ļ���Ϊһ�����ϸ�keyset
	   	    Iterator in = keySet.iterator(); //��������Iterator��
	   		
	   	    while(in.hasNext()){         //����������Ƿ���Ԫ�ء�
	   			Object key = in.next();  //��������е���һ��Ԫ�ء�
	   			Course cou = (Course)hash.get(key);         //����������пγ���Ϣ
	   		    System.out.println( cou.getCourseNo()+","+  //�����
	   		    					cou.getCourseName()+","+
	   		    					cou.getCourseGrade()  );	
	   		}
	   	    
	   		Scanner scanner = new Scanner(System.in);
	   		System.out.println("������γ̺ţ�");
			String courseNo = scanner.nextLine();
			
			if(hash.containsKey(courseNo) == true) {
				
				System.out.println("������ÿγ̵ĳɼ���");
				int grade = scanner.nextInt();
				
				sc.setStudentNo(studentNo);
				sc.setCourseNo(courseNo);
				sc.setGrade(grade);
				scdao.insert(sc);//���ѡ��
				System.out.println("ѡ�εǼǳɹ�!");
			}
			else{
			   System.err.println("ѡ�εǼ�ʧ��!");
			}  
    	}
    	else {
    		System.out.println("���ݿ��޴�ѧ����Ϣ������������");
    		Guanlisc.show();
    	}
//		 StudentUI.show(studentNo,studentPassword);
    }	
}
