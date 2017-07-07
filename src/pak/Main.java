package pak;

public class Main {

	public static void main(String[] args) {
		
		PersonDAO p = new PersonDAO();
		Person per = p.getPerson(7);
		System.out.println(per.getName());
	}
}