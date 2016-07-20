package com.neuedu.my12306.usermgr.test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.*;
import com.neuedu.my12306.usermgr.service.*;

public class CityServiceTest {

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
		CityService c = CityService.getService();
		try {
			Assert.assertNotNull(c.exactSearch("id", 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFuzzySearch() throws Exception {
		CityService c = CityService.getService();
		try {
			Assert.assertNotNull(c.fuzzySearch("id", "1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testProId() throws Exception {
		CityService c = CityService.getService();
		try {
			Assert.assertNotNull(c.getCityListByProid("110000"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}