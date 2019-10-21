
public class Dxc {
	public static void main(String[] args) {
		Download file=new Download();
		Thread loading=new Thread(file);
		loading.start();
	}

}
class Download implements Runnable{
	boolean []data=new boolean[100];
	public void run(){
		while(true){
			int begin=(int)(Math.random()*100);
			int end=(int)(Math.random()*100);
			for(int i=begin;i<end&&i<=100;i++)
			{
				if(data[i]==false)
				{
					data[i]=true;
					System.out.println(i);
				}
					
			}
		}
	}
}
