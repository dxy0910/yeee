package dao;

import java.io.*;
import entity.*;
import view.MainUI;
import java.util.*;

public class StudentDao implements IDao {
	private static StudentDao instance;
	private HashMap<String, Student> students = null;
	private Student student;
	private static  String file="student.txt";  //file��ʾ��ַ
	private StudentDao() throws Exception {
	//˽��ѧ�����ݿ�   //�����ļ�txt�洢ѧ�����ݣ�ֻ�����޲���
		//�����������ʲô�ģ��������ĵ�������
//		System.out.println("111");
		students = read(file);    //�ļ��ڵ��������ݸ�students��ϣ
//		System.out.println("222");
  	   	System.out.println(students.size());//����ӳ��Ĵ�С����ʾӳ���д��ڵļ�ֵ�Ե�����
//  	   	System.out.println("333");
//		students = new HashMap<String, Student>();               // students��ȫ�����ݴ�ŵĵط�
//		student = new Student();                                 //newһ��ѧ������
//
//		FileInputStream fi = new FileInputStream("student.txt"); //�����ַ������ ������
//		ObjectInputStream oi = new ObjectInputStream(fi);        //�����ַ������������
//		students = (HashMap<String, Student>)oi.readObject();
//		fi.close();
//		oi.close();
	}
	
	public HashMap<String,IEntity> getAllEntities() throws Exception{
		//������ϣʵ��  ��˽�й�ϣ���Զ���
		HashMap students = new HashMap<String,IEntity>();  //����
		students = read(file); //students ����fileָ���ļ�������ݲ��浽hash��
		return students;       //��������ѧ����Ϣ
    }
	
	public static StudentDao getInstance() throws Exception {
		//System.out.println("111");			  	 	//�ṩ����ʵ��������
		if(instance == null) {                	 	//������ݿ�Ϊ��
			synchronized(StudentDao.class) { 	 	//����   ����ʽ
				instance = new StudentDao(); 	 	//����ʵ������
//				System.out.println("444");
				return instance;             	 	//����ʵ������
			}
		}
//		System.out.println("555");
		return instance;
	}
	
	public HashMap<String, Student> read(String file) throws Exception {
		//��ϣ����    �ϼ� getAllEntities()
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
   		//��ϣд��
		FileOutputStream fs = new FileOutputStream(file,true);
   		OutputStreamWriter ow = new OutputStreamWriter(fs);
   		PrintWriter pw = new PrintWriter(ow,true);
   		
   		Set keySet=students.keySet();   //��
   		Iterator it=keySet.iterator();  //ֵ
   		
   		while(it.hasNext()) {    //������ȡ
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
	
	//��
	public void insert(IEntity entity) throws Exception {
		Student st = (Student)entity; // ǿתstudent��
  	   	students.put(st.getStudentNo(),st);
//HashMap.put()�������ڽ�ӳ����뵽ӳ���С����Խ��ض�������ӳ���ֵ���뵽�ض�ӳ����
//�������������Կ������ǰ��ֵ������ֵ�滻�����������һ���¶ԣ���ô�öԽ���Ϊ������롣  	   
  	   	FileOutputStream fs = new FileOutputStream(new File("student.txt"));//����ļ�����
		writer(file,students);    ////����ӹ��������ѧ����Ϣ���´����ļ�
		
		
//		students.put(student.getStudentNo(),student);
//      FileOutputStream fs = new FileOutputStream("student.txt");
//      ObjectOutputStream os = new ObjectOutputStream(fs);
//      os.writeObject(students);
//      os.close();
//      fs.close();
	}

	//ɾ��
	public void delete() throws Exception {
		Scanner scanner = new Scanner(System.in);
 	   	System.out.print("������Ҫɾ��ѧ����ѧ�ţ�");
		String studentNo = scanner.nextLine();
		if(students.containsKey(studentNo)==true) {
			students.remove(studentNo);//ɾ��  ����ѧ��ɾ��ѧ����Ϣ
//remove�����ײ�ʵ�����ǵ�����removeNode������ɾ����ֵ�Խڵ㣬���Ҹ��ݷ��صĽڵ����ȡ��key��Ӧ��ֵ			   
			FileOutputStream fs = new FileOutputStream(new File("student.txt"));//����ļ�����
			writer(file, students); //��ɾ�����������ѧ����Ϣ���´����ļ�
			System.out.println("ע���ɹ���");
		}else {
		    System.out.println("û�д��û������������룡");
		}
	}
	//������
	public void update() throws Exception {
		Scanner scanner = new Scanner(System.in);
 	  	System.out.print("����������ѧ�ţ�");
 	  	String studentNo = scanner.nextLine();
 	  	System.out.print("�������������룺");
 	  	String Password = scanner.nextLine();
 	  	if(  students.containsKey(studentNo)==true && //���ڸ�ѧ����Ϣ
 	  			//�÷���ֻ����һ������key_element�����������ò�������Ӧ��map�ڼ����ӳ��ļ���
 	  			//����ֵ�������⵽��Կ�Ĵ��ڣ���÷������ز���ֵtrue�����򷵻�false�� 	  			
 	  			( students.get(studentNo).getStudentPassword().equals(Password) )  ) {
 	  	        //������ݿ��е�ѧ�������������ѧ�������Ƿ�һ��
 	  		//�޸�����	
 	  		Student student=new Student();
		 	System.out.print("���������޸ĵ����룺");
	   		String studentPassword= scanner.nextLine();
	   		student = students.get(studentNo);
	   		
	   		System.out.print("���ٴ��������޸ĵ����룺");
	   		String studentPassword2= scanner.nextLine();
	   		student = students.get(studentNo);
	   		
	   		if( studentPassword.equals(studentPassword2) ) {
	   			student.setStudentPassword(studentPassword);
	   			students.put(studentNo, student);
	   			//hashmap�е�put����//��ӳ����뵽ӳ���С�����ζ�����ǿ��Խ��ض�������ӳ���ֵ���뵽�ض�ӳ���С�
	   			//�������������Կ������ǰ��ֵ������ֵ�滻�����������һ���¶ԣ���ô�öԽ���Ϊ������롣
	   			FileOutputStream fs = new FileOutputStream(new File("student.txt"));
	   			writer(file, students);
	   			System.out.println("�޸ĳɹ�!");
	   		}
 	  	}
 	  	else {
			System.out.println("����˺Ż��������!���������룡");
//			MainUI.show1();
		}
	}
	
	public void studentid (String Id) {
		getEntity(Id);
	}
	
	//���ʵ�廯���� ��ͨ��ID���һ�ø�ѧ�ŵ�ѧ����Ϣ
	public IEntity getEntity(String Id) { //������һ��ѧ�ţ�����һ��ʵ��
		return students.get(Id);           //ͨ��get�������Ҳ�����һ��
    }

	public static void main(String[] args) throws Exception {
		
	}

}
