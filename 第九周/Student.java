package �ھ���;

public class Student {
	public String num;
	public String name;
	public String gender;
	public String college;
	public String password;
	public Student()
	{
		
	}
	
	public Student(String num, String name, String gender, String college, String password) {
		super();
		this.num = num;
		this.name = name;
		this.gender = gender;
		this.college = college;
		this.password = password;
	}
	public String toString()
	{
		return ("ѧ�ţ�"+this.num+"������"+this.name+" �Ա�:"+this.gender+" ѧԺ:"+this.college);
	}
	public boolean judge(String num,String password) {
		if(this.num.equals(num)&&this.password.equals(password))
			return true;
		else
			return false;
	}
	
    
}
