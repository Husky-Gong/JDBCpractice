package ConnPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class prepareStatement {
	public static void main(String[] args) {
		String userName = "root";
		String passWord = "Zz010013";
		String url = "jdbc:mysql://localhost:3306/practice01?useUnicode=true&useSSL=false&charsetEncoding=utf8";
		Connection conn = null;
		PreparedStatement ps = null;
		try (Scanner input = new Scanner(System.in);
				){
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, passWord);
			String sql = "update javatest\n" + 
					"set name='xinghao'\n" + 
					"where address=?";
			ps = conn.prepareStatement(sql);
			System.out.println("please input your choice: wuhan or guangxi");
			String address = input.next();
			ps.setString(1, address);
			int rows = ps.executeUpdate();
			System.out.println(rows);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
