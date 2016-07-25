package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.Province;

public class ProvinceDaoImpl implements ProvinceDao {
	private Connection conn = null;

	public ProvinceDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	public ProvinceDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Province c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String add_sql = "insert into tab_province(province) values(?)";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(add_sql);
			pstmt.setString(1, c.getProvince());
			pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return true;
	}

	@Override
	public boolean del(Province c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String del_sql = "delete from tab_province where province=?";
		// String sql = "delete from students where Name='" + name + "'";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(del_sql);
			pstmt.setString(1, c.getProvince());
			pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return true;
	}

	@Override
	public boolean alter(Province c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String ALT_sql = "update tab_province set province=? where id=?";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(ALT_sql);
			pstmt.setString(1, c.getProvince());
			pstmt.setInt(2, c.getId());
			pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return true;
	}

	@Override
	public List<Province> getList() throws Exception {
		// TODO Auto-generated method stub
		String find_sql = "select * from tab_province";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Province> result = new ArrayList<Province>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(find_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Province one = new Province();
				one.setId(rs.getInt("id"));
				one.setProvinceid(rs.getString("provinceid"));
				one.setProvince(rs.getString("Province"));
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
	public Province exactSearch(String s, Object o) throws Exception {
		// TODO Auto-generated method stub
		// "select * from  readermessage WHERE 读者姓名='张勇'"
		ResultSet rs = null;
		Province c = null;
		PreparedStatement pstmt = null;
		String ES_sql = "select * from tab_province Where " + s + "=?";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(ES_sql);
			pstmt.setObject(1, o);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				c = new Province();
				c.setProvince(rs.getString("province"));
				c.setId(rs.getInt("id"));
			}
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return c;
	}

	@Override
	public List<Province> fuzzySearch(String s, Object o) throws Exception {
		// TODO Auto-generated method stub
		// String sql = "SELECT MerchandiseID, MName, Number, InPrice, Explain"+
		// " FROM repertory where MName like '%?%'";
		String FS_sql = "select * from tab_province where " + s + " like '%"+ o + "%'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Province> result = new ArrayList<Province>();
		try {
			// System.out.println(FS_sql);
			pstmt = (PreparedStatement) conn.prepareStatement(FS_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Province one = new Province();
				one.setId(rs.getInt("id"));
				one.setProvince(rs.getString("Province"));
				result.add(one);
			}
		} finally {
			DBUtils.closeStatement(rs, pstmt);
			// if(rs!=null)rs.close();
		}
		return result;
	}

}
