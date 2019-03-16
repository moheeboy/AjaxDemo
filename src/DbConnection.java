import java.sql.*;

public class DbConnection {

	public boolean isValidUser(String email, String password) throws Exception{
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/ajaxdemo","postgres","root");
		PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM user_data WHERE 'email' = ?");
		System.out.println("After creating prepared statement. email -- " + email + "  ---" + password);
		pStmt.setString(1, email);
		System.out.println("before executing query");
		ResultSet rs = pStmt.executeQuery();
		conn.close();
		int count=0;
		String dbPassword = "-";
		while(rs.next()){
			count++;
			dbPassword = rs.getString(4);
		}
		System.out.println("count value " + count);
		if(dbPassword.equals(password)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean registerUser(String firstName, String lastName, String email, String password) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/ajaxdemo","postgres","root");
		PreparedStatement p2Stmt = conn.prepareStatement("INSERT INTO info VALUES (?, ?, ?, ?, 0)");
		p2Stmt.setString(1, email);
		p2Stmt.setString(2, firstName);
		p2Stmt.setString(3, lastName);
		p2Stmt.setString(4, password);
		try {
			p2Stmt.executeUpdate();
			conn.close();
			return true;
		}catch(Exception e) {
			conn.close();
			return false;
		}
	}
}
