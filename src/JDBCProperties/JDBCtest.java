package JDBCProperties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCtest {
	public static void main(String[] args) {
		
		try (Connection conn = GetConnect.getConnection();
				Statement st = conn.createStatement();
				){
			ResultSet rs = null;
			String name,address;
			StringBuilder sb = new StringBuilder();
			rs = st.executeQuery("select name,address from javatest");
			while(rs.next()) {
				sb.setLength(0);
				name = rs.getString(1);
				address = rs.getString(2);
				sb.append("Name= ").append(name).append("address= ").append(address);
				System.out.println(sb.toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
