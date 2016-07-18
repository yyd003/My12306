package com.neuedu.my12306.usermgr.dao;

import java.util.List;
import com.neuedu.my12306.usermgr.domain.City;

public interface CityDao {
	public abstract List<City> getList() throws Exception;

	public abstract boolean add(City c) throws Exception;

	public abstract boolean del(City c) throws Exception;

	public abstract boolean alter(City c) throws Exception;

	public abstract List<City> exactSearch(String s, Object o) throws Exception;

	public abstract List<City> fuzzySearch(String s, Object o)
			throws Exception;
}
