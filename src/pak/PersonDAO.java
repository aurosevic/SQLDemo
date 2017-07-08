package pak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDAO {

	private Connection con = null;
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/samuraj?useSSL=true", "root", "andrija");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Person getPerson(int id) {
		Person p = new Person();
		p.setId(id);
		try {
			String query = "select * from podaci where id = " + id;
			
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
	
	public void addPerson(int id, String name, String surname) {
		String query = "insert into podaci values (?, ?, ?)";
		//	Change data from specific row:
		//	"update podaci set ime = 'Anica', prezime = 'Dobra' where id = 10"
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, surname);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}