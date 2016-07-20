package com.neuedu.my12306.usermgr.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.my12306.usermgr.service.*;

public class ProvinceServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	// @Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	// @Test
	public void testDel() {
		fail("Not yet implemented");
	}

	// @Test
	public void testAlter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetList() {
		ProvinceService c = ProvinceService.getService();
		try {
			Assert.assertNotNull(c.getlist());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testExactSearch() throws Exception {
		ProvinceService c = ProvinceService.getService();
		try {
			Assert.assertNotNull(c.exactSearch("id", 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFuzzySearch() throws Exception {
		ProvinceService c = ProvinceService.getService();
		try {
			Assert.assertNotNull(c.fuzzySearch("id", "1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}