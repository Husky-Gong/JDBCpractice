package ConnPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createStatement {
	public static void main(String[] args) {
		try {
			String userName = "root";
			String pwd = "Zz010013";
			String url = "jdbc:mysql://localhost:3306/practice01?useunicode=true&useSSL=false&charsetEncoding=utf8";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, userName, pwd);
			Statement st = conn.createStatement();
			String sql = "update javatest set name='zexi007' where address in ('wuhan','guangxi')";
			int rows = st.executeUpdate(sql);
			System.out.println(rows);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
