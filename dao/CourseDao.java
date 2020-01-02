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
    	//��ϣ����
   		FileInputStream fs = new FileInputStream(file);
   		InputStreamReader ir = new InputStreamReader(fs);
   		BufferedReader br = new BufferedReader(ir);//����ʹ��Ĭ�ϴ�С���뻺�����Ļ����ַ�������
   		HashMap<String,Course> course = new HashMap<String,Course>();
   		
   		String str = null;
   		while( (str = br.readLine() )//��ȡһ���ı���
   				!= null){
   			String[] strs = str.split(",");//���� "," �Ͽ��ַ������Ҳ���ʾ  ","
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
    	//��ϣд��
   		FileOutputStream fs = new FileOutputStream(file,true);
   		OutputStreamWriter ow = new OutputStreamWriter(fs);
   		PrintWriter pw = new PrintWriter(ow,true);
   		
   		Set keySet=courses.keySet();
   		Iterator it=keySet.iterator();
   		
   		while(it.hasNext()) {
   			Object key = it.next();
   			Course cou = (Course)courses.get(key);
   		    pw.println( //��ӡ
   		    		cou.getCourseNo()+","+
   		    		cou.getCourseName()+","+
   		    		cou.getCourseGrade()   );	
   		}
   		fs.close();
   		ow.close();
   		pw.close();
   	}
    public static CourseDao getInstance() throws Exception {
    	//�ṩ����ʵ��������
 	   	if(instance == null) {//������ݿ�Ϊ��
 	   		synchronized(CourseDao.class) {//����   ����ʽ
 	   				instance = new CourseDao();//����ʵ������
 	   				return instance;//����ʵ������
 	   			}
 	   	}
 	   	return instance;
    }
    //���
	public void insert(IEntity entity) throws Exception {
		 Course st = (Course)entity;
		 courses.put(st.getCourseNo(),st);//�����һ���¶ԣ�����Ϊһ��������в����ϣ��
		 FileOutputStream fs = new FileOutputStream(new File("course.txt"));//��ո��ļ�����
		 writer(file, courses);//��courses�еĿγ�����д��file��
	}
	//ɾ��
	public void delete() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�����뽫Ҫע��ע���Ŀγ̱�ţ�");
		String courseNo = scanner.nextLine();
		if(courses.containsKey(courseNo)==true) {//�������޴˿γ̱��
			
			courses.remove(courseNo);//remove���ڴ�map��ɾ���κ��ض�����ӳ�䡣ɾ����Map���κ��ض�����ֵ��			
			FileOutputStream fs = new FileOutputStream(new File("course.txt"));
			writer(file, courses);
			
			System.out.println("ע���ɹ���");
		}else {
			System.out.println("�޴˿γ̣������²���");
		}
	}
	//�Ŀγ���Ϣ
	public void update() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ƻ��޸ĵĿγ̺ţ�");
		String courseNo = scanner.nextLine();
        if(courses.containsKey(courseNo)==true) {
        	Course course=new Course();
			System.out.println("1-�޸Ŀγ�����2-�޸Ŀγ̷�����0-�˳�");
			String option = scanner.nextLine();
			switch (option) {
				case "1"://�޸Ŀγ���	
					System.out.print("�������µĿγ����ƣ�");
					String courseName = scanner.nextLine();
					
					course = courses.get(courseNo);
					course.setCourseName(courseName);
					courses.put(courseNo, course);//�滻֮ǰ��ֵ
					
					FileOutputStream fs = new FileOutputStream(new File("course.txt"));
					writer(file, courses);
					System.out.println("�޸ĳɹ�!");
					break;
				case "2"://�޸Ŀγ̷���
					System.out.print("�������µķ�����");
					int courseGrade= scanner.nextInt();
					
					course=courses.get(courseNo);
					course.setCourseGrade(courseGrade);
					courses.put(courseNo, course);
					
					FileOutputStream fs1 = new FileOutputStream(new File("course.txt"));
					writer(file, courses);
					System.out.println("�޸ĳɹ�!");
					break;
				}
        }
        else {
     	   System.out.println("û�д˿γ̣�");
//     	   System.out.println("�Ƿ���Ҫ�����γ̣�");
//     	   ����insert
        }
    	   Guanlicourse.show();
	}
	
	public HashMap<String, entity.IEntity> getAllEntities() throws Exception {
		HashMap hash = new HashMap<String,IEntity>();
		hash=read(file);
		return hash;
	}
	//����id���ؿγ�����
	public IEntity getEntity(String Id) {
		return courses.get(Id);
	}

}
