package view;

import java.util.*;
import biz.*;
import dao.*;
import entity.*;

public class CourseSelection {
	//��ҳ�棨������ʼ��
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		LoginUI.show();
//	}
	public static void main() throws Exception{
		LoginUI.show();
	}
	
	public static void show1(String studentNo,String studentPassword) throws Exception{
	    //ѡ��
		HashMap<String, IEntity> hash = new HashMap<String,IEntity>();
		StudentDao studentDao = StudentDao.getInstance();
	    
		hash = studentDao.getAllEntities();//hash����������ݿ��е�����ѧ����Ϣ
		
	    if(hash.containsKey(studentNo)==true && 
	 ( ((Student)hash.get(studentNo)).getStudentPassword().equals(studentPassword)) ){
			SCBiz scb = new SCBiz();
			scb.selectioncourse(studentNo,studentPassword);
		}
	}
	
	public static void show2(String studentNo,String studentPassword) throws Exception{
	    //��ѡ
		HashMap<String, IEntity> hash = new HashMap<String,IEntity>();
		StudentDao studentDao = StudentDao.getInstance();
		hash = studentDao.getAllEntities();
		
		if(hash.containsKey(studentNo)==true && 
	 ( ((Student)hash.get(studentNo)).getStudentPassword().equals(studentPassword)) ){
			SCDao scd = SCDao.getInstance();
			scd.delete();
		}
		
	}
}
