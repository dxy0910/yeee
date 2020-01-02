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
    										//�ṩ����ʵ��������
    	if(instance == null) {				//������ݿ�Ϊ��
    		synchronized(SCDao.class) {		//����   ����ʽ
    			instance = new SCDao();		//����ʵ������
    			return instance;			//����ʵ������
    		}
    	}
    	return instance;
    }
    
    public static HashMap<String,SC>  read(String file) throws Exception{
    	//��ϣ��ȡ
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
    	//��ϣд��
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
	//���
	public void insert(IEntity entity) throws Exception {
		SC st = (SC)entity;
		scs.put(st.getStudentNo(),st);
		FileOutputStream fs = new FileOutputStream(new File("sc.txt"));
		writer(file, scs);
	}
	//ɾ��
	@Override
	public void delete() throws Exception  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������Ҫɾ��ѡ����Ϣ��ѧ��ѧ�ţ�");
		String studentNo = scanner.nextLine();
		if(scs.containsKey(studentNo) == true) {
			scs.remove(studentNo);
			FileOutputStream fs = new FileOutputStream(new File("sc.txt"));
			writer(file, scs);
			System.out.println("ע���ɹ���");
		}
		else {
			System.out.println("���ݿ����޴�ѧ��ѧ�ţ�����������");
			Guanlisc.show();
		}			  
	}    
	//�޸�
	@Override
	public void update() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������޸�ѧ��ѧ�ţ�");
		String studentNo = scanner.nextLine();
		
		if(scs.containsKey(studentNo) == true) {
			SC sc = new SC();
			System.out.println("������Ӧ�¿γ̷�����");
			int Grade = scanner.nextInt();
			sc = scs.get(studentNo);
			sc.setGrade(Grade);
			scs.put(studentNo, sc);
			FileOutputStream fs = new FileOutputStream(new File("sc.txt"));
			writer(file, scs);
			System.out.println("�޸ĳɹ�!");
		}
		else {
			System.out.println("δ�д�ѧ����ѡ����Ϣ!");
         	Guanlisc.show();			
		}
	}
	
	@Override //���������д���෽���õ�,�����ע����Ա��ⷽ����������д��
	//�ṩһ�������� ���Ե���hashmap�ķ���
	public HashMap<String, IEntity> getAllEntities() throws Exception  {
		HashMap hash = new HashMap<String,IEntity>();
		hash=read(file);
		return hash;
	}

	public void sourseid(String Id) { //���Ҹ��˿γ���Ϣ
		getEntity(Id);
	}
	@Override
	public IEntity getEntity(String Id) {
		return scs.get(Id);
	}

}
