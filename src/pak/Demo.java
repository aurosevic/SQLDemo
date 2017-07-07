package pak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/samuraj?verifyServerCertificate=false&useSSL=true";
		String user = "root";
		String pass = "andrija";
		
		//	DQL
		String query = "select ime, prezime from podaci";
		//	DML
		int userId = 9;
		String ime = "Hiroko";
		String prezime = "Yamada";
		String q = "insert into podaci values (?, ?, ?)";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		PreparedStatement st = con.prepareStatement(q);
		st.setInt(1, userId);
		st.setString(2, ime);
		st.setString(3, prezime);
		
		// Dodavanje redova u tabele
		int count = st.executeUpdate();
		System.out.println(count + "row/s affected");
		
		// Citanje redova iz tabela
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			String name = rs.getString("ime");
			String surname = rs.getString("prezime");
			System.out.println(name + " " + surname);
		}
		
		st.close();
		con.close();
	}
}