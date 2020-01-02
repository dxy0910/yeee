package biz;

import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import view.LoginUI;
import view.MainUI;

//学生信息数据访问
public class StudentBiz {
	StudentDao studentDao;      //建立学生数据库连接
	private Student student;    //创建私有学生类型
	
	//用户登录 （来自LoginUI调用）
	public void login(String studentNo, String studentPassword) throws Exception  {
		studentDao = StudentDao.getInstance();                 //获得学生的实例对象
		student = (Student) studentDao.getEntity(studentNo);   //用得到的学号建立学生实体
		if (student == null) {
			System.out.println("抱歉！用户不存在！请重新输入！");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("登录成功");
			MainUI.show1(studentPassword, studentPassword);   //调用主页界面
		} else {
			System.out.println("密码不正确");
			//MainUI.show();   //调用主页界面
			return;
		}
	}
	
	//管理员登录 （来自LoginUI调用）
	public void logina(String guanliNo, String guanliPassword) throws Exception {
		if (guanliNo.equals("123456") && guanliPassword.equals("123456")) {
			System.out.println("登录成功");
			MainUI.show2(guanliPassword, guanliPassword);   //调用主页界面
		} else {
			System.out.println("账号或密码不正确");
			return;
		}
	}
	//修改密码
    public void modifyPassword() throws Exception {	 
   		 student = new Student();
   		 studentDao = StudentDao.getInstance();
   		 studentDao.update();  //调用删除
//   		 MainUI.show1();       //
    }
	//注册学生信息，业务逻辑实现
	public void register(String studentNo, 		   //学号
						String studentName, 	   //名字
						String studentGender,      //性别
						int studentAge,            //年龄
						String studentDepartment,  //院系
						String firstPassword,      //第一次密码
						String secondPassword) throws Exception {   //第二次密码
		
		if(firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentGender(studentGender);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			studentDao = StudentDao.getInstance();
			
			studentDao.insert(student); // 注册
			System.out.println("注册成功！");
			LoginUI.show();
		}else {
			System.out.println("两次密码不同！请重新输入");
			return ;
		}
	}
	
}
