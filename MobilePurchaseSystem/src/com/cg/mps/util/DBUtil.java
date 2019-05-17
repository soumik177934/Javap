package com.cg.mps.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.mps.exception.MobileDBException;

public class DBUtil {
	private static Connection conn;
	static FileInputStream fs = null;
	public static Connection getConnection() throws MobileDBException {
		if(conn==null){
			try {
				fs = new FileInputStream("Resource/jdbc.properties");
				Properties prop = new Properties();
				prop.load(fs);
				String driver = prop.getProperty("driver");
				String url=prop.getProperty("url");
				String user =prop.getProperty("user");
				String pass =prop.getProperty("password");
				Class.forName(driver);
				System.out.println("Driver found");
				
				conn = DriverManager.getConnection(url,user,pass);
				
				System.out.print("Database Connection Successfull\n");
			} catch (ClassNotFoundException e) {
				throw new MobileDBException("Driver not found");
			} catch (SQLException e) {
				throw new MobileDBException("Problem in establishing connection "+e.getMessage());
			} catch (FileNotFoundException e) {
				System.err.println("jdbc properties file not found");
			} catch (IOException e) {
				System.err.println("Error in fetching file data");
			}finally{
				if(fs != null){
					try {
						fs.close();
					} catch (IOException e) {
						System.err.println(e.getMessage());;
					}
				}
			}
		}
		return conn;
	}
	

}