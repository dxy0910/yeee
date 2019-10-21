
public class Dsy {
	public static void main(String[] args) {
		Teacher t = new Teacher();	 
		new Thread(t, "语文老师").start();	
		new Thread(t, "数学老师").start();	
		new Thread(t, "英语老师").start();
		}
}
class Teacher implements Runnable {
	private int notes = 80;   
	public void run() {    
		while (true) {    
			dispatchNotes(); // 调用售票方法      
			if (notes <= 0) {    
				break;           
				}      
			}  
		}
	  private synchronized void dispatchNotes() {  
		  if (notes > 0) {     
			  try {            
				  Thread.sleep(10); // 经过的线程休眠10毫秒     
				  } 
			  catch (InterruptedException e) { 
				  e.printStackTrace();        
				  }             
			  System.out.println(Thread.currentThread().getName() + "---发出的笔记" +                notes--);   
			  }  
		  }
}
