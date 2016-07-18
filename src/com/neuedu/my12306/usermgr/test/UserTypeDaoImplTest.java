package com.neuedu.my12306.usermgr.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.*;
import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.*;

public class UserTypeDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
	public void testAdd() {
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
		UserTypeDao c = new UserTypeDaoImpl(DBUtils.getConnection());
		try {
			Assert.assertNotNull(c.exactSearch("id", 1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFuzzySearch() throws Exception{
		UserTypeDao c = new UserTypeDaoImpl(DBUtils.getConnection());
		try {
			Assert.assertNotNull(c.fuzzySearch("content", "证"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
