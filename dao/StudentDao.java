package dao;

import java.io.*;
import entity.*;
import view.MainUI;
import java.util.*;

public class StudentDao implements IDao {
	private static StudentDao instance;
	private HashMap<String, Student> students = null;
	private Student student;
	private static  String file="student.txt";  //file表示地址
	private StudentDao() throws Exception {
	//私有学生数据库   //构建文件txt存储学生数据，只调用无操作
		//这个方法是做什么的？？？在哪调用了他
//		System.out.println("111");
		students = read(file);    //文件内的所有内容给students哈希
//		System.out.println("222");
  	   	System.out.println(students.size());//返回映射的大小，表示映射中存在的键值对的数量
//  	   	System.out.println("333");
//		students = new HashMap<String, Student>();               // students是全部数据存放的地方
//		student = new Student();                                 //new一个学生对象
//
//		FileInputStream fi = new FileInputStream("student.txt"); //定义字符输出流 读出来
//		ObjectInputStream oi = new ObjectInputStream(fi);        //建立字符输出流缓冲区
//		students = (HashMap<String, Student>)oi.readObject();
//		fi.close();
//		oi.close();
	}
	
	public HashMap<String,IEntity> getAllEntities() throws Exception{
		//建立哈希实体  让私有哈希可以读出
		HashMap students = new HashMap<String,IEntity>();  //建立
		students = read(file); //students 读出file指的文件里的内容并存到hash里
		return students;       //返回所有学生信息
    }
	
	public static StudentDao getInstance() throws Exception {
		//System.out.println("111");			  	 	//提供单例实例化对象
		if(instance == null) {                	 	//如果数据库为空
			synchronized(StudentDao.class) { 	 	//锁死   饿汉式
				instance = new StudentDao(); 	 	//创建实例对象
//				System.out.println("444");
				return instance;             	 	//返回实例对象
			}
		}
//		System.out.println("555");
		return instance;
	}
	
	public HashMap<String, Student> read(String file) throws Exception {
		//哈希读出    上级 getAllEntities()
		FileInputStream fs=new FileInputStream(file);
   		InputStreamReader ir=new InputStreamReader(fs);
   		BufferedReader br=new BufferedReader(ir);
   		HashMap<String,Student> students = new HashMap<String,Student>();
   		String str=null;
   		while((str=br.readLine())!=null){
   			String[] strs=str.split(",");
   			Student stu=new Student();
   			System.out.println(str);
   			stu.setStudentNo(strs[0]);
//   			System.out.println("1");
   			stu.setStudentName(strs[1]);
//   			System.out.println("2");
   			stu.setStudentGender(strs[2]);
//   			System.out.println("3");
   			stu.setStudentAge(Integer.parseInt(strs[3]));
//   			System.out.println("4");
   			stu.setStudentDepartment(strs[4]);
//   			System.out.println("5");
   			stu.setStudentPassword(strs[5]);
//   			System.out.println("6");
   			students.put(strs[0],stu); 
//   			System.out.println("7");
   			System.out.println(stu);
   		}
   		System.out.println("111");
   		fs.close();
   		ir.close();
   		br.close();
   		System.out.println("222");
   		return students;
	}
	public static void writer(String file,HashMap<String,Student> students) throws Exception{
   		//哈希写入
		FileOutputStream fs = new FileOutputStream(file,true);
   		OutputStreamWriter ow = new OutputStreamWriter(fs);
   		PrintWriter pw = new PrintWriter(ow,true);
   		
   		Set keySet=students.keySet();   //键
   		Iterator it=keySet.iterator();  //值
   		
   		while(it.hasNext()) {    //遍历读取
   			Object key=it.next();
   			Student stu=(Student)students.get(key);
   		    pw.println( 
   		    		stu.getStudentNo()+","+
   		    		stu.getStudentName()+","+
   		    		stu.getStudentGender()+","+
   		    		stu.getStudentAge()+","+
   		    		stu.getStudentDepartment()+","+
   		    		stu.getStudentPassword() 
   		    		);
   		}
   		fs.close();
   		ow.close();
   		pw.close();
   	}
	
	//增
	public void insert(IEntity entity) throws Exception {
		Student st = (Student)entity; // 强转student类
  	   	students.put(st.getStudentNo(),st);
//HashMap.put()方法用于将映射插入到映射中。可以将特定键及其映射的值插入到特定映射中
//如果传递现有密钥，则先前的值将被新值替换。如果传递了一对新对，那么该对将作为整体插入。  	   
  	   	FileOutputStream fs = new FileOutputStream(new File("student.txt"));//清空文件内容
		writer(file,students);    ////把添加过后的所有学生信息重新存入文件
		
		
//		students.put(student.getStudentNo(),student);
//      FileOutputStream fs = new FileOutputStream("student.txt");
//      ObjectOutputStream os = new ObjectOutputStream(fs);
//      os.writeObject(students);
//      os.close();
//      fs.close();
	}

	//删除
	public void delete() throws Exception {
		Scanner scanner = new Scanner(System.in);
 	   	System.out.print("请输入要删除学生的学号：");
		String studentNo = scanner.nextLine();
		if(students.containsKey(studentNo)==true) {
			students.remove(studentNo);//删除  根据学号删除学生信息
//remove方法底层实际上是调用了removeNode方法来删除键值对节点，并且根据返回的节点对象取得key对应的值			   
			FileOutputStream fs = new FileOutputStream(new File("student.txt"));//清空文件内容
			writer(file, students); //把删除过后的所有学生信息重新存入文件
			System.out.println("注销成功！");
		}else {
		    System.out.println("没有此用户！请重新输入！");
		}
	}
	//改密码
	public void update() throws Exception {
		Scanner scanner = new Scanner(System.in);
 	  	System.out.print("请输入您的学号：");
 	  	String studentNo = scanner.nextLine();
 	  	System.out.print("请输入您的密码：");
 	  	String Password = scanner.nextLine();
 	  	if(  students.containsKey(studentNo)==true && //存在该学生信息
 	  			//该方法只接受一个参数key_element（键参数）该参数引用应在map内检查其映射的键。
 	  			//返回值：如果检测到密钥的存在，则该方法返回布尔值true，否则返回false。 	  			
 	  			( students.get(studentNo).getStudentPassword().equals(Password) )  ) {
 	  	        //检测数据库中的学生密码与输入的学生密码是否一致
 	  		//修改密码	
 	  		Student student=new Student();
		 	System.out.print("请输入新修改的密码：");
	   		String studentPassword= scanner.nextLine();
	   		student = students.get(studentNo);
	   		
	   		System.out.print("请再次输入新修改的密码：");
	   		String studentPassword2= scanner.nextLine();
	   		student = students.get(studentNo);
	   		
	   		if( studentPassword.equals(studentPassword2) ) {
	   			student.setStudentPassword(studentPassword);
	   			students.put(studentNo, student);
	   			//hashmap中的put方法//将映射插入到映射中。这意味着我们可以将特定键及其映射的值插入到特定映射中。
	   			//如果传递现有密钥，则先前的值将被新值替换。如果传递了一对新对，那么该对将作为整体插入。
	   			FileOutputStream fs = new FileOutputStream(new File("student.txt"));
	   			writer(file, students);
	   			System.out.println("修改成功!");
	   		}
 	  	}
 	  	else {
			System.out.println("你的账号或密码错误!请重新输入！");
//			MainUI.show1();
		}
	}
	
	public void studentid (String Id) {
		getEntity(Id);
	}
	
	//获得实体化对象 ，通过ID查找获得该学号的学生信息
	public IEntity getEntity(String Id) { //传过来一个学号，返回一个实体
		return students.get(Id);           //通过get方法查找并返回一行
    }

	public static void main(String[] args) throws Exception {
		
	}

}
