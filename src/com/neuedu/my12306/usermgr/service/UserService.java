package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.UserDao;
import com.neuedu.my12306.usermgr.dao.UserDaoImpl;
import com.neuedu.my12306.usermgr.domain.User;

public class UserService {
	public static final UserService instance = new UserService();

	public static UserService getCertTypeService() {
		return instance;
	}

	private UserService() {
	}

	public List<User> getCertTypelist() throws Exception {
		Connection conn = null;
		List<User> res = null;
		try {
			conn = DBUtils.getConnection();
			UserDao certTypeDao = new UserDaoImpl(conn);
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
public boolean add(User ct) {

	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		UserDao ctd = new UserDaoImpl();

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
public boolean del(User ct) {
	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		UserDao ctd = new UserDaoImpl();

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
public User exactSearch(String key, Object value) {
	Connection conn = DBUtils.getConnection();
	User ct = null;
	
	try {
		DBUtils.beginTranscation(conn);

		UserDao ctd = new UserDaoImpl();

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


public List<User> fuzzySearch(String key, Object value) throws SQLException {
	Connection conn = DBUtils.getConnection();
	List<User> ctList = null;
	
	try {
		DBUtils.beginTranscation(conn);

		UserDao ctd = new UserDaoImpl();

		ctList = ctd.fuzzySearch(key, value);

		DBUtils.commit(conn);
	} catch (Exception e) {
		// TODO Auto-generated catch block

		DBUtils.rollback(conn);
		e.printStackTrace();
		
	} finally {
		DBUtils.closeConnection(conn);
	}
	
	for (User certType : ctList) {
		System.out.println(certType.getId() + ":" + certType.getUsername());
	}
	
	return ctList;
}



@SuppressWarnings("finally")
public boolean alter(User ct) {
	Connection conn = DBUtils.getConnection();
	boolean IsSuccess = true;
	
	try {
		DBUtils.beginTranscation(conn);

		UserDao ctd = new UserDaoImpl();

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
