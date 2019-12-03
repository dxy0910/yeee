package San;

public class Main {
	public static void main(String[] args) {
		Customer person1=new Customer("zhangsan");
		Movie movie1=new Movie("lisi",2);
		Rental rental1=new Rental(movie1,22);
		person1.addRental(rental1);
		System. out.print(person1. statement());
	}
}
