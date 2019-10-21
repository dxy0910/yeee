
public class Dey {
	public static void main(String[] args){	
		MyThread1 me=new MyThread1();	
		Thread thread=new Thread(me);	
		thread.start();		
		for(int i=0;i<100;i++){
			System.out.println("main");	
			}	
		}
}
class MyThread1 implements Runnable{

	public void run(){

		for(int i=0;i<50;i++)

		{

			System.out.println("new");

		}

	}
}
