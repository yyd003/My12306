package com.neuedu.my12306.usermgr.test;

import static org.junit.Assert.*;

import java.sql.*;

import org.junit.*;

import com.neuedu.my12306.common.Md5Utils;
import com.neuedu.my12306.usermgr.domain.*;
import com.neuedu.my12306.usermgr.service.*;

public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	// 测试添加用户
//	 @Test
		public void testAddUser() {
			// fail("Not yet implemented");
			UserService service = UserService.getService();
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
		UserService service = UserService.getService();
		User U=new User();   
		Date birthday = Date.valueOf("2005-12-12");
		U.setUsername("123");
		U.setPassword("321");
		U.setCert_type(1);
		U.setUser_type(1);
		U.setCity(110100);
		U.setBirthday(birthday);
		U.setRule("1");
		U.setRealname("bc");
		U.setCert("12345678901");
		U.setStatus("1");
		U.setSex("1");
		U.setId(3);
		Assert.assertTrue(service.alter(U));
	}

//	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testExactSearch() throws Exception {
		UserService c = UserService.getService();
		try {
			Assert.assertNotNull(c.exactSearch("id", 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFuzzySearch() throws Exception {
		UserService c = UserService.getService();
		try {
			Assert.assertNotNull(c.fuzzySearch("id", "1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testLOGIN() {
		UserService c = UserService.getService();
			try {
				Assert.assertNotNull(c.login("admin", Md5Utils.md5("123456")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

	@Test
	public void testIPL() {
		UserService c = UserService.getService();
			try {
				Assert.assertNotNull(c.getIpList());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
}