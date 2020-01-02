package dao;

import entity.*;
import view.*;
import view.Guanlisc;
import java.io.*;
import java.util.*;

public class SCDao implements IDao {
	
	private static SCDao instance = null;
    private HashMap<String,SC> scs;
    private  SC sc;
    private static  String file="sc.txt";
    
    private SCDao() throws Exception {
 	   scs = read(file);
 	   System.out.println(scs.size());
    }
    
    public static SCDao getInstance() throws Exception {
    										//提供单例实例化对象
    	if(instance == null) {				//如果数据库为空
    		synchronized(SCDao.class) {		//锁死   饿汉式
    			instance = new SCDao();		//创建实例对象
    			return instance;			//返回实例对象
    		}
    	}
    	return instance;
    }
    
    public static HashMap<String,SC>  read(String file) throws Exception{
    	//哈希读取
		FileInputStream fs = new FileInputStream(file);
		InputStreamReader ir = new InputStreamReader(fs);
		BufferedReader br = new BufferedReader(ir);
		HashMap<String,SC> scs = new HashMap<String,SC>();
		String str = null;
		while((str = br.readLine()) != null){
			SC sc = new SC();			
			String[] strs = str.split(",");
			
			sc.setStudentNo(strs[0]);
			sc.setCourseNo(strs[1]);
			sc.setGrade(Integer.parseInt(strs[2]));
			scs.put(strs[0],sc);
		}
		fs.close();
		ir.close();
		br.close();
		return scs;
	}
    public static void writer(String file,HashMap<String,SC> scs) throws Exception{
    	//哈希写入
		FileOutputStream fs = new FileOutputStream(file,true);
		OutputStreamWriter ow = new OutputStreamWriter(fs);
		PrintWriter pw = new PrintWriter(ow,true);
		
		Set keySet = scs.keySet();
		Iterator it = keySet.iterator();
		
		while(it.hasNext()) {
			Object key = it.next();
			SC sc = (SC)scs.get(key);
		    pw.println(  sc.getStudentNo()+","+
		    			 sc.getCourseNo()+","+
		    			 sc.getGrade()  );	
		}
		fs.close();
		ow.close();
		pw.close();
	}
	//添加
	public void insert(IEntity entity) throws Exception {
		SC st = (SC)entity;
		scs.put(st.getStudentNo(),st);
		FileOutputStream fs = new FileOutputStream(new File("sc.txt"));
		writer(file, scs);
	}
	//删除
	@Override
	public void delete() throws Exception  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入要删除选课信息的学生学号：");
		String studentNo = scanner.nextLine();
		if(scs.containsKey(studentNo) == true) {
			scs.remove(studentNo);
			FileOutputStream fs = new FileOutputStream(new File("sc.txt"));
			writer(file, scs);
			System.out.println("注销成功！");
		}
		else {
			System.out.println("数据库中无此学生学号！请重新输入");
			Guanlisc.show();
		}			  
	}    
	//修改
	@Override
	public void update() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入修改学生学号：");
		String studentNo = scanner.nextLine();
		
		if(scs.containsKey(studentNo) == true) {
			SC sc = new SC();
			System.out.println("请输入应新课程分数：");
			int Grade = scanner.nextInt();
			sc = scs.get(studentNo);
			sc.setGrade(Grade);
			scs.put(studentNo, sc);
			FileOutputStream fs = new FileOutputStream(new File("sc.txt"));
			writer(file, scs);
			System.out.println("修改成功!");
		}
		else {
			System.out.println("未有此学生的选课信息!");
         	Guanlisc.show();			
		}
	}
	
	@Override //这个用于重写父类方法用的,用这个注解可以避免方法名跟参数写错
	//提供一个公开的 可以调用hashmap的方法
	public HashMap<String, IEntity> getAllEntities() throws Exception  {
		HashMap hash = new HashMap<String,IEntity>();
		hash=read(file);
		return hash;
	}

	public void sourseid(String Id) { //查找个人课程信息
		getEntity(Id);
	}
	@Override
	public IEntity getEntity(String Id) {
		return scs.get(Id);
	}

}
