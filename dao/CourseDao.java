package dao;

import java.io.*;
import java.util.*;
import entity.*;
import view.*;

public class CourseDao implements IDao {
	
	private static CourseDao instance = null;
    private HashMap<String,Course> courses;
    private  Course course;
    
    private static  String file="course.txt";
    
    private CourseDao() throws Exception {
 	   courses=read(file);
 	   System.out.println(courses.size());
    }
    public static HashMap<String,Course>  read(String file) throws Exception{
    	//哈希读出
   		FileInputStream fs = new FileInputStream(file);
   		InputStreamReader ir = new InputStreamReader(fs);
   		BufferedReader br = new BufferedReader(ir);//创建使用默认大小输入缓冲区的缓冲字符输入流
   		HashMap<String,Course> course = new HashMap<String,Course>();
   		
   		String str = null;
   		while( (str = br.readLine() )//读取一行文本。
   				!= null){
   			String[] strs = str.split(",");//根据 "," 断开字符串，且不显示  ","
   			Course stu = new Course();
   			stu.setCourseNo(strs[0]);
   			stu.setCourseName(strs[1]);
   			stu.setCourseGrade(Integer.parseInt(strs[2]));
   			course.put(strs[0],stu);
   		}
   		fs.close();
   		ir.close();
   		br.close();
   		return course;
   	}
    public static void writer(String file,
    		HashMap<String,Course> courses) throws Exception{
    	//哈希写入
   		FileOutputStream fs = new FileOutputStream(file,true);
   		OutputStreamWriter ow = new OutputStreamWriter(fs);
   		PrintWriter pw = new PrintWriter(ow,true);
   		
   		Set keySet=courses.keySet();
   		Iterator it=keySet.iterator();
   		
   		while(it.hasNext()) {
   			Object key = it.next();
   			Course cou = (Course)courses.get(key);
   		    pw.println( //打印
   		    		cou.getCourseNo()+","+
   		    		cou.getCourseName()+","+
   		    		cou.getCourseGrade()   );	
   		}
   		fs.close();
   		ow.close();
   		pw.close();
   	}
    public static CourseDao getInstance() throws Exception {
    	//提供单例实例化对象
 	   	if(instance == null) {//如果数据库为空
 	   		synchronized(CourseDao.class) {//锁死   饿汉式
 	   				instance = new CourseDao();//创建实例对象
 	   				return instance;//返回实例对象
 	   			}
 	   	}
 	   	return instance;
    }
    //添加
	public void insert(IEntity entity) throws Exception {
		 Course st = (Course)entity;
		 courses.put(st.getCourseNo(),st);//如果是一对新对，则作为一个整体进行插入哈希中
		 FileOutputStream fs = new FileOutputStream(new File("course.txt"));//清空该文件数据
		 writer(file, courses);//讲courses中的课程数据写入file中
	}
	//删除
	public void delete() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入将要注销注销的课程编号：");
		String courseNo = scanner.nextLine();
		if(courses.containsKey(courseNo)==true) {//查找有无此课程编号
			
			courses.remove(courseNo);//remove用于从map中删除任何特定键的映射。删除了Map中任何特定键的值。			
			FileOutputStream fs = new FileOutputStream(new File("course.txt"));
			writer(file, courses);
			
			System.out.println("注销成功！");
		}else {
			System.out.println("无此课程！请重新查找");
		}
	}
	//改课程信息
	public void update() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入计划修改的课程号：");
		String courseNo = scanner.nextLine();
        if(courses.containsKey(courseNo)==true) {
        	Course course=new Course();
			System.out.println("1-修改课程名；2-修改课程分数；0-退出");
			String option = scanner.nextLine();
			switch (option) {
				case "1"://修改课程名	
					System.out.print("请输入新的课程名称：");
					String courseName = scanner.nextLine();
					
					course = courses.get(courseNo);
					course.setCourseName(courseName);
					courses.put(courseNo, course);//替换之前的值
					
					FileOutputStream fs = new FileOutputStream(new File("course.txt"));
					writer(file, courses);
					System.out.println("修改成功!");
					break;
				case "2"://修改课程分数
					System.out.print("请输入新的分数：");
					int courseGrade= scanner.nextInt();
					
					course=courses.get(courseNo);
					course.setCourseGrade(courseGrade);
					courses.put(courseNo, course);
					
					FileOutputStream fs1 = new FileOutputStream(new File("course.txt"));
					writer(file, courses);
					System.out.println("修改成功!");
					break;
				}
        }
        else {
     	   System.out.println("没有此课程！");
//     	   System.out.println("是否需要创建课程？");
//     	   调用insert
        }
    	   Guanlicourse.show();
	}
	
	public HashMap<String, entity.IEntity> getAllEntities() throws Exception {
		HashMap hash = new HashMap<String,IEntity>();
		hash=read(file);
		return hash;
	}
	//根据id返回课程数据
	public IEntity getEntity(String Id) {
		return courses.get(Id);
	}

}
