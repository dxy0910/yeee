package user;
	
	import java.util.Date;
	import java.util.Random;
	
	public class DdUser implements User{
	private String phoneNumber;
	private String callTo;
	private StringBuffer commucationRecords;
	public User(String phoneNumber){
	this.phoneNumber=phoneNumber;
	this.commucationRecords=new StringBuffer();
	}
	public void generateCommucationRecord(){
	int recordNum=new Random().nextInt(10);
	for(int i=0;i<=recordNum;i++){
	long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
	long timeEnd=timeStart+60000+new Random().nextInt(600000);
	callTo=this.getCallToPhoneNumber();
	this.commucationRecords.append(this.phoneNumber+","+timeStart+","+timeEnd+","+this.callTo+";");
	}
	}
	public String getCallToPhoneNumber(){
	return "1593906"+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10))+String.valueOf(new Random().nextInt(10));
	}
	public String accountFee(long timeStart,long timeEnd){
	double feePerMinute=50;
	int minutes=Math.round((timeEnd-timeStart)/60000);
	double feeTotal=feePerMinute*minutes;
	return String.format("%.4f",feeTotal);
	}
	public void printDetails(){
	String allRecords=this.commucationRecords.toString();
	String []recordArray=allRecords.split(";");
	for(int i=0;i<recordArray.length;i++){
	String []recordField=recordArray[i].split(",");
	System.out.println("主叫:"+recordField[0]);
	System.out.println("被叫:"+recordField[3]);
	System.out.println("通话开始时间:"+new Date(Long.parseLong(recordField[1])));
	System.out.println("通话结束时间:"+new Date(Long.parseLong(recordField[2])));
	System.out.println("计费:"+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+"元");
	}
	}
	}
