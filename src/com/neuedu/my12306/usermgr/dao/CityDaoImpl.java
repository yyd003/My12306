package com.neuedu.my12306.usermgr.dao;

import java.sql.*;
import java.util.*;
import com.mysql.jdbc.PreparedStatement;
import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.City;

public class CityDaoImpl implements CityDao {
	private Connection conn = null;

	public CityDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	public CityDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<City> getCityListByProid(String s) throws Exception {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		City c = null;
		PreparedStatement pstmt = null;
		List<City> result = new ArrayList<City>();
		String ES_sql = "select * from tab_city Where father=?";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(ES_sql);
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				c = new City();
				c.setId(rs.getInt("id"));
				c.setCity(rs.getString("city"));
				result.add(c);
			}
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return result;
	}

	@Override
	public boolean add(City c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String add_sql = "insert into tab_city(city) values(?)";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(add_sql);
			pstmt.setString(1, c.getCity());
			pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return true;
	}

	@Override
	public boolean del(City c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String del_sql = "delete from tab_city where city=?";
		// String sql = "delete from students where Name='" + name + "'";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(del_sql);
			pstmt.setString(1, c.getCity());
			pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return true;
	}

	@Override
	public boolean alter(City c) throws Exception {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String ALT_sql = "update tab_city set city=? where id=?";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(ALT_sql);
			pstmt.setString(1, c.getCity());
			pstmt.setInt(2, c.getId());
			pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return true;
	}

	@Override
	public List<City> getList() throws Exception {
		// TODO Auto-generated method stub
		String find_sql = "select * from tab_city";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<City> result = new ArrayList<City>();
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(find_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				City one = new City();
				one.setId(rs.getInt("id"));
				one.setCity(rs.getString("City"));
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
	public List<City> exactSearch(String s, Object o) throws Exception {
		// TODO Auto-generated method stub
		// "select * from  readermessage WHERE 读者姓名='张勇'"
		ResultSet rs = null;
		City c = null;
		PreparedStatement pstmt = null;
		List<City> result = new ArrayList<City>();
		String ES_sql = "select * from tab_city Where " + s + "=?";
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(ES_sql);
			pstmt.setObject(1, o);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				c = new City();
				c.setId(rs.getInt("id"));
				c.setCity(rs.getString("city"));
				result.add(c);
			}
		} finally {
			DBUtils.closeStatement(rs, pstmt);
		}
		return result;
	}

	@Override
	public List<City> fuzzySearch(String s, Object o) throws Exception {
		// TODO Auto-generated method stub
		// String sql = "SELECT MerchandiseID, MName, Number, InPrice, Explain"+
		// " FROM repertory where MName like '%?%'";
		String FS_sql = "select * from tab_city where " + s + " like '%" + o
				+ "%'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<City> result = new ArrayList<City>();
		try {
			// System.out.println(FS_sql);
			pstmt = (PreparedStatement) conn.prepareStatement(FS_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				City one = new City();
				one.setId(rs.getInt("id"));
				one.setCity(rs.getString("city"));
				result.add(one);
			}
		} finally {
			DBUtils.closeStatement(rs, pstmt);
			// if(rs!=null)rs.close();
		}
		return result;
	}

}