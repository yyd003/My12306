package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.UserTypeDao;
import com.neuedu.my12306.usermgr.dao.UserTypeDaoImpl;
import com.neuedu.my12306.usermgr.domain.UserType;

public class UserTypeService {
	public static final UserTypeService instance = new UserTypeService();

	public static UserTypeService getService() {
		return instance;
	}

	private UserTypeService() {
	}

	public List<UserType> getlist() throws Exception {
		Connection conn = null;
		List<UserType> res = null;
		try {
			conn = DBUtils.getConnection();
			UserTypeDao certTypeDao = new UserTypeDaoImpl(conn);
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
public boolean add(UserType ct) {

	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		UserTypeDao ctd = new UserTypeDaoImpl(conn);

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
public boolean del(UserType ct) {
	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		UserTypeDao ctd = new UserTypeDaoImpl(conn);

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
public UserType exactSearch(String key, Object value) {
	Connection conn = DBUtils.getConnection();
	UserType ct = null;
	
	try {
		DBUtils.beginTranscation(conn);

		UserTypeDao ctd = new UserTypeDaoImpl(conn);

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


public List<UserType> fuzzySearch(String key, Object value) throws SQLException {
	Connection conn = DBUtils.getConnection();
	List<UserType> ctList = null;
	
	try {
		DBUtils.beginTranscation(conn);

		UserTypeDao ctd = new UserTypeDaoImpl(conn);

		ctList = ctd.fuzzySearch(key, value);

		DBUtils.commit(conn);
	} catch (Exception e) {
		// TODO Auto-generated catch block

		DBUtils.rollback(conn);
		e.printStackTrace();
		
	} finally {
		DBUtils.closeConnection(conn);
	}
	
	for (UserType certType : ctList) {
		System.out.println(certType.getId() + ":" + certType.getContent());
	}
	
	return ctList;
}



@SuppressWarnings("finally")
public boolean alter(UserType ct) {
	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		UserTypeDao ctd = new UserTypeDaoImpl(conn);

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
