package com.neuedu.my12306.usermgr.service;

import java.sql.*;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.*;
import com.neuedu.my12306.usermgr.domain.City;

public class CityService {
	private static Connection conn = null;
	public static final CityService instance = new CityService();

	public static CityService getService() {
		return instance;
	}

	public List<City> getlist() throws Exception {
		List<City> res = null;
		try {
			conn = DBUtils.getConnection();
			CityDao certTypeDao = new CityDaoImpl(conn);
			DBUtils.beginTranscation(conn);
			res = certTypeDao.getList();
			DBUtils.commit(conn);
		} catch (Exception e) {
			// TODO: handle exception
			DBUtils.rollback(conn);
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return res;

	}

	@SuppressWarnings("finally")
	public boolean add(City ct) {

		Connection conn = DBUtils.getConnection();
		boolean IsSuccess = true;

		try {
			DBUtils.beginTranscation(conn);

			CityDao ctd = new CityDaoImpl(conn);

			IsSuccess = ctd.add(ct);

			DBUtils.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			DBUtils.rollback(conn);
			e.printStackTrace();

		} finally {
			DBUtils.closeConnection(conn);
			return IsSuccess;
		}
	}

	@SuppressWarnings("finally")
	public boolean del(City ct) {
		Connection conn = DBUtils.getConnection();
		boolean IsSuccess = true;

		try {
			DBUtils.beginTranscation(conn);

			CityDao ctd = new CityDaoImpl(conn);

			IsSuccess = ctd.del(ct);

			DBUtils.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			DBUtils.rollback(conn);
			e.printStackTrace();

		} finally {
			DBUtils.closeConnection(conn);
			return IsSuccess;
		}
	}

	@SuppressWarnings("finally")
	public List<City> exactSearch(String key, Object value) {
		conn = DBUtils.getConnection();
		List<City> ct = null;

		try {
			DBUtils.beginTranscation(conn);

			CityDao ctd = new CityDaoImpl(conn);

			ct = ctd.exactSearch(key, value);

			DBUtils.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			DBUtils.rollback(conn);
			e.printStackTrace();

		} finally {
			DBUtils.closeConnection(conn);
			return ct;
		}
	}
	

	public List<City> fuzzySearch(String key, Object value) throws SQLException {
		conn = DBUtils.getConnection();
		List<City> ctList = null;

		try {
			DBUtils.beginTranscation(conn);

			CityDao ctd = new CityDaoImpl(conn);

			ctList = ctd.fuzzySearch(key, value);

			DBUtils.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			DBUtils.rollback(conn);
			e.printStackTrace();

		} finally {
			DBUtils.closeConnection(conn);
		}

		for (City certType : ctList) {
			System.out.println(certType.getId() + ":" + certType.getCity());
		}

		return ctList;
	}

	@SuppressWarnings("finally")
	public boolean alter(City ct) {
		Connection conn = DBUtils.getConnection();
		boolean IsSuccess = true;

		try {
			DBUtils.beginTranscation(conn);

			CityDao ctd = new CityDaoImpl(conn);

			IsSuccess = ctd.alter(ct);

			DBUtils.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			DBUtils.rollback(conn);
			e.printStackTrace();

		} finally {
			DBUtils.closeConnection(conn);
			return IsSuccess;
		}
	}

	public List<City> getCityListByProid(String s) throws SQLException {
		Connection conn = DBUtils.getConnection();
		List<City> ctList = null;

		try {
			DBUtils.beginTranscation(conn);

			CityDao ctd = new CityDaoImpl(conn);

			ctList = ctd.getCityListByProid(s);

			DBUtils.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			DBUtils.rollback(conn);
			e.printStackTrace();

		} finally {
			DBUtils.closeConnection(conn);
		}

//		for (City certType : ctList) {
//			System.out.println(certType.getId() + ":" + certType.getCity());
//		}

		return ctList;
	}
public City findByCity(String s){
	Connection conn = DBUtils.getConnection();
	City c=null;
	List<City>cl=null;
	try {
		DBUtils.beginTranscation(conn);

		CityDao ctd = new CityDaoImpl(conn);

		cl = ctd.exactSearch("cityid", s);
		if(!cl.isEmpty())	c=cl.get(0);

		DBUtils.commit(conn);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		try {
			DBUtils.rollback(conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.printStackTrace();

	} finally {
		DBUtils.closeConnection(conn);
	}
		return c;		
	}
}
