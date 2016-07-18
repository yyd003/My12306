package com.neuedu.my12306.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			String URL = "jdbc:mysql://127.0.0.1:3306/my12306?useUnicode=true&amp;characterEncoding=UTF-8";
			String URL = "jdbc:mysql://127.0.0.1:3306/my12306?charset=UTF8";
			String user = "root";
			String pwd = "123456";
			conn = DriverManager.getConnection(URL, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			 throw new ServiceException("未找到对应的数据库驱动!",e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			 throw new ServiceException("连接失败,请检查数据库连接信息!",e);
		}
		return conn;
	}

	public static void beginTranscation(Connection conn) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can not begin transaction");
//			throw new ServiceException("Can not begin transaction",e);
		}

	}

	public static void commit(Connection conn) {
		try {
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can not commit");
//			throw new ServiceException("Can not commit",e);
		}
	}

	public static boolean closeStatement(ResultSet z, PreparedStatement x)
			throws SQLException {
		if (z != null && x != null) {
			z.close();
			x.close();
			return true;
		}
		return false;

	}

	public static boolean closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}


	public static void rollback(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		conn.rollback();
	}
}
