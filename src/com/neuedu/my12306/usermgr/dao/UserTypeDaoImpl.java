package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.UserType;

public class UserTypeDaoImpl implements UserTypeDao {
	private Connection conn = null;

	public UserTypeDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	public UserTypeDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(UserType c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String add_sql = "insert into tab_usertype(content) values(?)";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(add_sql);
			pstmt.setString(1, c.getContent());
			pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return true;
	}

	@Override
	public boolean del(UserType c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String del_sql = "delete from tab_usertype where content=?";
		// String sql = "delete from students where Name='" + name + "'";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(del_sql);
			pstmt.setString(1, c.getContent());
			pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return true;
	}

	@Override
	public boolean alter(UserType c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String ALT_sql = "update tab_usertype set content=? where id=?";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(ALT_sql);
			pstmt.setString(1, c.getContent());
			pstmt.setInt(2, c.getId());
			pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return true;
	}

	@Override
	public List<UserType> getList() throws Exception {
		// TODO Auto-generated method stub
		String find_sql = "select * from tab_usertype";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserType> result = new ArrayList<UserType>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(find_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserType one = new UserType();
				one.setId(rs.getInt("id"));
				one.setContent(rs.getString("Content"));
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
	public UserType exactSearch(String s, Object o) throws Exception {
		// TODO Auto-generated method stub
		// "select * from  readermessage WHERE 读者姓名='张勇'"
		ResultSet rs = null;
		UserType c = null;
		PreparedStatement pstmt = null;
		String ES_sql = "select * from tab_usertype Where " + s + "=?";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(ES_sql);
			pstmt.setObject(1, o);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				c = new UserType();
				c.setContent(rs.getString("content"));
				c.setId(rs.getInt("id"));
			}
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return c;
	}

	@Override
	public List<UserType> fuzzySearch(String s, Object o) throws Exception {
		// TODO Auto-generated method stub
		// String sql = "SELECT MerchandiseID, MName, Number, InPrice, Explain"+
		// " FROM repertory where MName like '%?%'";
		String FS_sql = "select * from tab_usertype where " + s + " like '%"+ o + "%'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserType> result = new ArrayList<UserType>();
		try {
			// System.out.println(FS_sql);
			pstmt = (PreparedStatement) conn.prepareStatement(FS_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserType one = new UserType();
				one.setId(rs.getInt("id"));
				one.setContent(rs.getString("Content"));
				result.add(one);
			}
		} finally {
			DBUtils.closeStatement(rs, pstmt);
			// if(rs!=null)rs.close();
		}
		return result;
	}

}
