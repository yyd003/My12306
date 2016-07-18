package com.neuedu.my12306.usermgr.dao;

import java.util.List;

import com.neuedu.my12306.usermgr.domain.CertType;

public interface CertTypeDao {
	public abstract List<CertType> getList() throws Exception;

	public abstract boolean add(CertType c) throws Exception;

	public abstract boolean del(CertType c) throws Exception;

	public abstract boolean alter(CertType c) throws Exception;

	public abstract CertType exactSearch(String s, Object o) throws Exception;

	public abstract List<CertType> fuzzySearch(String s, Object o)
			throws Exception;
}
