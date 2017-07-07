package pak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDAO {

	public Person getPerson(int id) {
		Person p = new Person();
		p.setId(id);
		try {
			String query = "select * from podaci where id = " + id;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/samuraj?useSSL=true", "root", "andrija");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			
			String name = rs.getString(2);
			p.setName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}