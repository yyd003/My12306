package com.neuedu.my12306.usermgr.test;

import static org.junit.Assert.*;

import java.sql.*;

import org.junit.*;

import com.neuedu.my12306.common.*;
import com.neuedu.my12306.usermgr.dao.*;
import com.neuedu.my12306.usermgr.domain.*;
import com.neuedu.my12306.usermgr.service.*;

public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	// 测试添加用户
	 @Test
		public void testAddUser() {
			// fail("Not yet implemented");
			UserService service = UserService.getCertTypeService();
			User U=new User();   
			Date birthday = Date.valueOf("2005-12-12");
			U.setUsername("123");
			U.setPassword("321");
			U.setCert_type(1);
			U.setUser_type(1);
			U.setCity(110100);
			U.setBirthday(birthday);
			U.setRule("1");
			U.setRealname("tc");
			U.setCert("12345678901");
			U.setStatus("1");
			U.setSex("1");
			Assert.assertTrue(service.add(U));
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

//	@Test
	public void testExactSearch() throws Exception {
		CityDao c = new CityDaoImpl(DBUtils.getConnection());
		try {
			Assert.assertNotNull(c.exactSearch("id", 1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
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