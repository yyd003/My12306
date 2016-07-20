package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.CertTypeDao;
import com.neuedu.my12306.usermgr.dao.CertTypeDaoImpl;
import com.neuedu.my12306.usermgr.domain.CertType;

public class CertTypeService {
	public static final CertTypeService instance = new CertTypeService();

	public static CertTypeService getService() {
		return instance;
	}

	private CertTypeService() {
	}

	public List<CertType> getlist() throws Exception {
		Connection conn = null;
		List<CertType> res = null;
		try {
			conn = DBUtils.getConnection();
			CertTypeDao certTypeDao = new CertTypeDaoImpl(conn);
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
public boolean add(CertType ct) {

	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		CertTypeDao ctd = new CertTypeDaoImpl(conn);

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
public boolean del(CertType ct) {
	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		CertTypeDao ctd = new CertTypeDaoImpl(conn);

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
public CertType exactSearch(String key, Object value) {
	Connection conn = DBUtils.getConnection();
	CertType ct = null;
	
	try {
		DBUtils.beginTranscation(conn);

		CertTypeDao ctd = new CertTypeDaoImpl(conn);

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


public List<CertType> fuzzySearch(String key, Object value) throws SQLException {
	Connection conn = DBUtils.getConnection();
	List<CertType> ctList = null;
	
	try {
		DBUtils.beginTranscation(conn);

		CertTypeDao ctd = new CertTypeDaoImpl(conn);

		ctList = ctd.fuzzySearch(key, value);

		DBUtils.commit(conn);
	} catch (Exception e) {
		// TODO Auto-generated catch block

		DBUtils.rollback(conn);
		e.printStackTrace();
		
	} finally {
		DBUtils.closeConnection(conn);
	}
	
	for (CertType certType : ctList) {
		System.out.println(certType.getId() + ":" + certType.getContent());
	}
	
	return ctList;
}



@SuppressWarnings("finally")
public boolean alter(CertType ct) {
	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		CertTypeDao ctd = new CertTypeDaoImpl(conn);

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
