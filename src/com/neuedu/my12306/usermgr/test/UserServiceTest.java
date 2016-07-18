package com.neuedu.my12306.usermgr.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.CityDao;
import com.neuedu.my12306.usermgr.dao.CityDaoImpl;

public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

//	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

//	@Test
	public void testAlter() {
		fail("Not yet implemented");
	}

//	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testExactSearch() throws Exception {
		CityDao c = new CityDaoImpl(DBUtils.getConnection());
		try {
			Assert.assertNotNull(c.exactSearch("id", 1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFuzzySearch() throws Exception {
		CityDao c = new CityDaoImpl(DBUtils.getConnection());
		try {
			Assert.assertNotNull(c.fuzzySearch("id", "1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}