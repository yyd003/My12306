package com.neuedu.my12306.usermgr.test;

import java.util.*;
import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.CertTypeDaoImpl;
import com.neuedu.my12306.usermgr.domain.CertType;

/*
 * 
 */
public class TestDBUtils {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int i[]={1,2};
		String S = "(";
		for (int j : i) {
			S+=String.valueOf(j);
			S+=",";
		}
		S=S.substring(0,S.length()-1);
		S+=")";
		System.out.println(S);
		showall();
		addtest();
		showall();
		// altertest();
		// showall();
		deltest();
		showall();
	}

	public static void altertest() throws Exception {
		CertTypeDaoImpl c = new CertTypeDaoImpl(DBUtils.getConnection());
		CertType newt = new CertType();
		newt.setContent("军官证");
		if (c.alter(newt)) {
			System.out.println("Alter success\n");
			DBUtils.closeConnection(c.getConn());
		} else {
			System.out.println("fail");
		}
	}

	public static void deltest() throws Exception {
		CertTypeDaoImpl c = new CertTypeDaoImpl(DBUtils.getConnection());
		CertType newt = new CertType();
		newt.setContent("学生证");
		if (c.del(newt)) {
			System.out.println("Delete success\n");
			DBUtils.closeConnection(c.getConn());
		} else {
			System.out.println("fail");
		}
	}

	public static void addtest() throws Exception {
		CertTypeDaoImpl c = new CertTypeDaoImpl(DBUtils.getConnection());
		CertType t= new CertType();
		t.setContent("学生证");
		if (c.add(t)) {
			System.out.println("Add success\n");
			DBUtils.closeConnection(c.getConn());
		} else {
			System.out.println("fail");
		}
	}

	public static void showall() throws Exception {
		List<CertType> temp = new ArrayList<CertType>();
		CertTypeDaoImpl c = new CertTypeDaoImpl(DBUtils.getConnection());
		temp = c.getList();
		System.out.println("show");
		for (CertType certType : temp) {
			System.out.println(certType);
		}
		System.out.println();
		DBUtils.closeConnection(c.getConn());
	}

}
