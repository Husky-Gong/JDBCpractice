package ConnPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCquery {
	public static void main(String[] args) {
		String userName = "root";
		String passWord = "Zz010013";
		String url = "jdbc:mysql://localhost:3306/practice01?useUnicode=true&useSSL=false&charsetEncoding=utf8";
		Connection conn = null;
		Statement st = null;
		ResultSet rs= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, passWord);
			st = conn.createStatement();
			String sql = "select name,address from javatest";
			rs = st.executeQuery(sql);
			StringBuilder sb = new StringBuilder();
			String name = null;
			String address = null;
			while(rs.next()) {
				sb.setLength(0);
				name = rs.getString(1);
				address = rs.getString(2);
				sb.append("Name = ").append(name).append("\t").append("Address = ").append(address);
				System.out.println(sb.toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
