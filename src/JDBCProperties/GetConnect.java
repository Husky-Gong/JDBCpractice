package JDBCProperties;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class GetConnect {
	private static Properties ppts = new Properties();
	
	static {
		try(
				InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("NetInfo.properties");
				){
			if(in == null) {
				throw new RuntimeException("Loading properties file failed.");
			}
			ppts.load(in);
		}catch(Exception e) {
					e.printStackTrace();
				}
	}
	
	public static Connection getConnection() {
		String userName = ppts.getProperty("userName");
		String url = ppts.getProperty("url");
		String passWord = ppts.getProperty("passWord");
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, passWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}