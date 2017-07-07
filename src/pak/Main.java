package pak;

public class Main {

	public static void main(String[] args) {
		
		PersonDAO p = new PersonDAO();
		p.connect();
		p.addPerson(11, "Andrijana", "Lepic");
		//	System.out.println(p.getPerson(7).getName());
	}
}