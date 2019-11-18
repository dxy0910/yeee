package puduction;
import user.*;
public class TelcomUserProduce extends Produce{
	public User produceUser(){
		return new TelcomUser("15939065755");
	}
}
