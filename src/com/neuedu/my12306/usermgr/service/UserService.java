package com.neuedu.my12306.usermgr.service;

import java.sql.*;
import java.util.*;

import com.neuedu.my12306.common.*;
import com.neuedu.my12306.usermgr.dao.*;
import com.neuedu.my12306.usermgr.domain.*;

public class UserService {
	public static final UserService instance = new UserService();

	public static UserService getInstance() {
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
		boolean IsSuccess = false;

		try {
			DBUtils.beginTranscation(conn);

			UserDao ctd = new UserDaoImpl(conn);

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

			UserDao ctd = new UserDaoImpl(conn);

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
	public boolean del(int ct[]) {
		Connection conn = DBUtils.getConnection();
		boolean IsSuccess = true;

		try {
			DBUtils.beginTranscation(conn);

			UserDao ctd = new UserDaoImpl(conn);

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

			UserDao ctd = new UserDaoImpl(conn);

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

	@SuppressWarnings("finally")
	public User findUser(User one) {
		Connection conn = DBUtils.getConnection();
		User ct = null;

		try {
			DBUtils.beginTranscation(conn);

			UserDao ctd = new UserDaoImpl(conn);

			ct = ctd.findUser(one);

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

			UserDao ctd = new UserDaoImpl(conn);

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

			UserDao ctd = new UserDaoImpl(conn);

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

	public boolean deleteUsersProcedure(int[] t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public List<IpAddress> getIpList() throws Exception {
		Connection conn = DBUtils.getConnection();
		List<IpAddress> ctList = null;

		try {
			DBUtils.beginTranscation(conn);

			UserDao ctd = new UserDaoImpl(conn);

			ctList = ctd.getIpList();

			DBUtils.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			DBUtils.rollback(conn);
			e.printStackTrace();

		} finally {
			DBUtils.closeConnection(conn);
		}

		for (IpAddress certType : ctList) {
			System.out.println(certType.getCnt() + ":" + certType.getIp());
		}

		return ctList;
	}

	@SuppressWarnings("finally")
	public User login(String username, String password) throws Exception {
		Connection conn = DBUtils.getConnection();
		User ct = null;

		try {
			DBUtils.beginTranscation(conn);

			UserDao ctd = new UserDaoImpl(conn);

			ct = ctd.login(username, password);

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

	public int getListPageCount(int t, User c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getListRowCount(User c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<User> getUserListRS(int t, int i, User c) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<User> res = null;
		try {
			conn = DBUtils.getConnection();
			UserDao certTypeDao = new UserDaoImpl(conn);
			DBUtils.beginTranscation(conn);
			res = certTypeDao.getUserListRS(t, i, c);
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

}
