package com.neuedu.my12306.usermgr.dao;

import java.util.List;

import com.neuedu.my12306.usermgr.domain.User;

public interface UserDao {
	public abstract List<User> getList() throws Exception;

	public abstract boolean add(User c) throws Exception;

	public abstract boolean del(User c) throws Exception;

	public abstract boolean alter(User c) throws Exception;

	public abstract User exactSearch(String s, Object o) throws Exception;

	public abstract List<User> fuzzySearch(String s, Object o)
			throws Exception;
}
