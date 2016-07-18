package com.neuedu.my12306.usermgr.dao;

import java.util.*;

import com.neuedu.my12306.usermgr.domain.*;

public interface UserDao {
	public abstract List<User> getList() throws Exception;

	public abstract boolean add(User c) throws Exception;

	public abstract boolean del(User c) throws Exception;

	public abstract boolean alter(User c) throws Exception;

	public abstract User exactSearch(String s, Object o) throws Exception;

	public abstract List<User> fuzzySearch(String s, Object o)
			throws Exception;
	
	public abstract boolean deleteUsersProcedure(int[] t) throws Exception;

	public abstract List<IpAddress> getIpList() throws Exception;
	
	public abstract int getListPageCount(int t,User c) throws Exception;

	public abstract int getListRowCount(User c) throws Exception;
	
	public abstract List<User> getUserListRS(int t,int i,User c) throws Exception;
	
	public abstract User login(String u,String p) throws Exception;

	public abstract int save(User c) throws Exception;

	boolean del(int[] i) throws Exception;
}
