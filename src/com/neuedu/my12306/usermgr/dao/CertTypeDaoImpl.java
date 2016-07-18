package com.neuedu.my12306.usermgr.dao;

import java.sql.*;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;
import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.CertType;

public class CertTypeDaoImpl implements CertTypeDao {
	private Connection conn = null;

	public CertTypeDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	public CertTypeDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(CertType c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String add_sql = "insert into tab_certtype(content) values(?)";
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
	public boolean del(CertType c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String del_sql = "delete from tab_certtype where content=?";
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
	public boolean alter(CertType c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String ALT_sql = "update tab_certtype set content=? where id=?";
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
	public List<CertType> getList() throws Exception {
		// TODO Auto-generated method stub
		String find_sql = "select * from tab_certtype";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CertType> result = new ArrayList<CertType>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(find_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CertType one = new CertType();
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
	public CertType exactSearch(String s, Object o) throws Exception {
		// TODO Auto-generated method stub
		// "select * from  readermessage WHERE 读者姓名='张勇'"
		ResultSet rs = null;
		CertType c = null;
		PreparedStatement pstmt = null;
		String ES_sql = "select * from tab_certtype Where " + s + "=?";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(ES_sql);
			pstmt.setObject(1, o);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				c = new CertType();
				c.setContent(rs.getString("content"));
				c.setId(rs.getInt("id"));
			}
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return c;
	}

	@Override
	public List<CertType> fuzzySearch(String s, Object o) throws Exception {
		// TODO Auto-generated method stub
		// String sql = "SELECT MerchandiseID, MName, Number, InPrice, Explain"+
		// " FROM repertory where MName like '%?%'";
		String FS_sql = "select * from tab_certtype where " + s + " like '%"+ o + "%'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CertType> result = new ArrayList<CertType>();
		try {
			// System.out.println(FS_sql);
			pstmt = (PreparedStatement) conn.prepareStatement(FS_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CertType one = new CertType();
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
