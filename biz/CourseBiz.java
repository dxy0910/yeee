package biz;

import dao.*;
import entity.*;
import view.MainUI;

public class CourseBiz {
	//�γ���Ϣ���ݷ���
	CourseDao courseDao;
    private Course course;
	public void register(String CourseNo,
						 String CourseName,
						 int CourseGrade  ) throws Exception {
		//����
		course = new Course();
		course.setCourseNo(CourseNo);
		course.setCourseName(CourseName);
		course.setCourseGrade(CourseGrade);
		courseDao = CourseDao.getInstance();
		courseDao.insert(course);
		System.out.println("ע��ɹ�!");
		MainUI.show2("123456","123456");
	}
	
	public void modifyPassword() throws Exception {
		//�޸Ŀγ���Ϣ
		course = new Course();
		courseDao = CourseDao.getInstance();
		courseDao.update();
		MainUI.show2("123456","123456");
	}
	
}