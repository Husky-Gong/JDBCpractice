package ConnPractice;


import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest1 {
	public static void main(String[] args) {
		String userName = "root";
		String pwd = "Zz010013";
		String url = "jdbc:mysql://localhost:3306/practice01?useUnicode=true&useSSL=false&charsetEncoding=utf8md";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, userName, pwd);
			System.out.println(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
