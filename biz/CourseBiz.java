package biz;

import dao.*;
import entity.*;
import view.MainUI;

public class CourseBiz {
	//课程信息数据访问
	CourseDao courseDao;
    private Course course;
	public void register(String CourseNo,
						 String CourseName,
						 int CourseGrade  ) throws Exception {
		//创建
		course = new Course();
		course.setCourseNo(CourseNo);
		course.setCourseName(CourseName);
		course.setCourseGrade(CourseGrade);
		courseDao = CourseDao.getInstance();
		courseDao.insert(course);
		System.out.println("注册成功!");
		MainUI.show2("123456","123456");
	}
	
	public void modifyPassword() throws Exception {
		//修改课程信息
		course = new Course();
		courseDao = CourseDao.getInstance();
		courseDao.update();
		MainUI.show2("123456","123456");
	}
	
}