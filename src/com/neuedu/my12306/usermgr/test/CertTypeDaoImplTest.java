package com.neuedu.my12306.usermgr.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.CertTypeDao;
import com.neuedu.my12306.usermgr.dao.CertTypeDaoImpl;

public class CertTypeDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testExactSearch() throws Exception {
		CertTypeDao c = new CertTypeDaoImpl(DBUtils.getConnection());
		try {
			Assert.assertNotNull(c.exactSearch("id", 1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testfuzzySearch() throws Exception {
		CertTypeDao c = new CertTypeDaoImpl(DBUtils.getConnection());
		try {
			Assert.assertNotNull(c.fuzzySearch("content", "证"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
