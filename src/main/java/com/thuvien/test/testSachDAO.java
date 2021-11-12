package com.thuvien.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.thuvien.DAO.SachDAO;
import com.thuvien.model.Sach;

public class testSachDAO {
	SachDAO sachDAO;

	@Test
	public void test_sachbyid() {
		long id = 1;
		Sach s = sachDAO.findByid(id);
		assertNotNull(s);
		assertEquals(s.getId(), 1);
		assertEquals(s.getTen(), "doremon");
		id = 10;
		s = sachDAO.findByid(id);
		assertNull(s);
	}

}
