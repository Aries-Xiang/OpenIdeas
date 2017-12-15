package config;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;


public class JdbcConn {

	public static Connection getConn(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/discpdb?useUnicode=true&characterEncoding=UTF-8";
		String userName = "root";
		String password = "";
		
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动加载失败");
		}
		try {
			conn = (Connection)DriverManager.getConnection(url,userName,password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
		
		return conn;
	}
}
