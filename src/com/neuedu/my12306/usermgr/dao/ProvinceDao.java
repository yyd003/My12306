package com.neuedu.my12306.usermgr.dao;

import java.util.List;

import com.neuedu.my12306.usermgr.domain.Province;

public interface ProvinceDao {
	public abstract List<Province> getList() throws Exception;

	public abstract boolean add(Province c) throws Exception;

	public abstract boolean del(Province c) throws Exception;

	public abstract boolean alter(Province c) throws Exception;

	public abstract Province exactSearch(String s, Object o) throws Exception;

	public abstract List<Province> fuzzySearch(String s, Object o)
			throws Exception;
}
