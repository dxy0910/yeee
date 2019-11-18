package 第十一周;

public class TelcomAccountSystem {
	public static void main(String[] args) {
		TelcomUser telcomUser=new TelcomUser("15939062360");
		telcomUser.generateCommucationRecord();
		telcomUser.printDetails();
	}
}
