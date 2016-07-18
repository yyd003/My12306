package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.ProvinceDao;
import com.neuedu.my12306.usermgr.dao.ProvinceDaoImpl;
import com.neuedu.my12306.usermgr.domain.Province;

public class ProvinceService {
	public static final ProvinceService instance = new ProvinceService();

	public static ProvinceService getCertTypeService() {
		return instance;
	}

	private ProvinceService() {
	}

	public List<Province> getCertTypelist() throws Exception {
		Connection conn = null;
		List<Province> res = null;
		try {
			conn = DBUtils.getConnection();
			ProvinceDao certTypeDao = new ProvinceDaoImpl(conn);
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
public boolean add(Province ct) {

	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		ProvinceDao ctd = new ProvinceDaoImpl();

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
public boolean del(Province ct) {
	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		ProvinceDao ctd = new ProvinceDaoImpl();

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
public Province exactSearch(String key, Object value) {
	Connection conn = DBUtils.getConnection();
	Province ct = null;
	
	try {
		DBUtils.beginTranscation(conn);

		ProvinceDao ctd = new ProvinceDaoImpl();

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


public List<Province> fuzzySearch(String key, Object value) throws SQLException {
	Connection conn = DBUtils.getConnection();
	List<Province> ctList = null;
	
	try {
		DBUtils.beginTranscation(conn);

		ProvinceDao ctd = new ProvinceDaoImpl();

		ctList = ctd.fuzzySearch(key, value);

		DBUtils.commit(conn);
	} catch (Exception e) {
		// TODO Auto-generated catch block

		DBUtils.rollback(conn);
		e.printStackTrace();
		
	} finally {
		DBUtils.closeConnection(conn);
	}
	
	for (Province certType : ctList) {
		System.out.println(certType.getId() + ":" + certType.getProvince());
	}
	
	return ctList;
}



@SuppressWarnings("finally")
public boolean alter(Province ct) {
	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		ProvinceDao ctd = new ProvinceDaoImpl();

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
}
