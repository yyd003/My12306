package com.neuedu.my12306.usermgr.dao;

import java.util.List;

import com.neuedu.my12306.usermgr.domain.UserType;

public interface UserTypeDao {
	public abstract List<UserType> getList() throws Exception;

	public abstract boolean add(UserType c) throws Exception;

	public abstract boolean del(UserType c) throws Exception;

	public abstract boolean alter(UserType c) throws Exception;

	public abstract UserType exactSearch(String s, Object o) throws Exception;

	public abstract List<UserType> fuzzySearch(String s, Object o)
			throws Exception;
}
