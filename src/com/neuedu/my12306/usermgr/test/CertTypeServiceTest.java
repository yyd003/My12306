package com.neuedu.my12306.usermgr.test;

import static org.junit.Assert.*;
import org.junit.*;
import com.neuedu.my12306.usermgr.service.CertTypeService;

public class CertTypeServiceTest {

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

	// @Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testExactSearch() throws Exception {
		CertTypeService c = CertTypeService.getService();
		try {
			Assert.assertNotNull(c.exactSearch("id", 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFuzzySearch() throws Exception {
		CertTypeService c = CertTypeService.getService();
		try {
			Assert.assertNotNull(c.fuzzySearch("id", "1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
