package com.neuedu.my12306.usermgr.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;
import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.*;

public class UserDaoImpl implements UserDao{
			private Connection conn = null;

			public UserDaoImpl(Connection conn) {
				// TODO Auto-generated constructor stub
				this.conn = conn;
			}

			public UserDaoImpl() {
				// TODO Auto-generated constructor stub
			}

			@Override
			public boolean add(User c) throws Exception {
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				String add_sql = "insert into tab_user(username,password,rule,realname,sex,city,cert_type,cert,birthday,user_type,status) values(?,?,2,'tc',1,110100,110000,1,000,?,1,1)";
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(add_sql);
					pstmt.setString(1, c.getUsername());
					pstmt.setString(2, c.getPassword());
					pstmt.setDate(3,  (Date) c.getBirthday());
					pstmt.executeUpdate();
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return true;
			}

			@Override
			public boolean del(int[] i) throws Exception {
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				String it ="[";
				for (int j : i) {
					it+=i[j];it+=",";
				}
				//{1}
				String del_sql = "delete from tab_user where id in ?";
				// String sql = "delete from students where Name='" + name + "'";
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(del_sql);
					pstmt.setString(1, it);
					pstmt.executeUpdate();
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return true;
			}
			
			@Override
			public boolean del(User c) throws Exception {
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				//{1}
				String del_sql = "delete from tab_user where Username = ?";
				// String sql = "delete from students where Name='" + name + "'";
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(del_sql);
					pstmt.setString(1, c.getUsername());
					pstmt.executeUpdate();
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return true;
			}

			@Override
			public boolean alter(User c) throws Exception {
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				String ALT_sql = "update tab_user set Username=? where id=?";
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(ALT_sql);
					pstmt.setString(1, c.getUsername());
					pstmt.setInt(2, c.getId());
					pstmt.executeUpdate();
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return true;
			}

			@Override
			public List<User> getList() throws Exception {
				// TODO Auto-generated method stub
				String find_sql = "select * from tab_user";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<User> result = new ArrayList<User>();
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(find_sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						User one = new User();
						one.setId(rs.getInt("id"));
						one.setUsername(rs.getString("User"));
						result.add(one);
					}
				} finally {
					DBUtils.closeStatement(rs, pstmt);
					// if(rs!=null)rs.close();
				}
				return result;
			}

			public Connection getConn() {
				return conn;
			}

			public void setConn(Connection conn) {
				this.conn = conn;
			}

			@Override
			public User exactSearch(String s, Object o) throws Exception {
				// TODO Auto-generated method stub
				// "select * from  readermessage WHERE 读者姓名='张勇'"
				ResultSet rs = null;
				User c = null;
				PreparedStatement pstmt = null;
				String ES_sql = "select * from tab_user Where " + s + "=?";
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(ES_sql);
					pstmt.setObject(1, o);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						c = new User();
						c.setUsername(rs.getString("user"));
						c.setId(rs.getInt("id"));
					}
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return c;
			}

			@Override
			public List<User> fuzzySearch(String s, Object o) throws Exception {
				// TODO Auto-generated method stub
				// String sql = "SELECT MerchandiseID, MName, Number, InPrice, Explain"+
				// " FROM repertory where MName like '%?%'";
				String FS_sql = "select * from tab_user where " + s + " like '%"+ o + "%'";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<User> result = new ArrayList<User>();
				try {
					// System.out.println(FS_sql);
					pstmt = (PreparedStatement) conn.prepareStatement(FS_sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						User one = new User();
						one.setId(rs.getInt("id"));
						one.setUsername(rs.getString("user"));
						result.add(one);
					}
				} finally {
					DBUtils.closeStatement(rs, pstmt);
					// if(rs!=null)rs.close();
				}
				return result;
			}

			@Override
			public boolean deleteUsersProcedure(int[] t) throws Exception {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<IpAddress> getIpList() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public User login(String u, String p) throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int save(User c) throws Exception {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getListPageCount(int t, User c) throws Exception {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getListRowCount(User c) throws Exception {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<User> getUserListRS(int t, int i, User c)
					throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

}
