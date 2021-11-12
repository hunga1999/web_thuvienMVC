package com.thuvien.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thuvien.controller.LoginController;

public class testLoginController {
	
	LoginController loginController= new LoginController();
	
	@Test
	public void testLogin() {
		assertEquals(loginController.checkLogin(null,"admin", "admin", null),"redirect:/home");
		assertEquals(loginController.checkLogin(null,"admin1", "admin", null),"index");
	}
	@Test
	public void testLogin1() {
		assertEquals(loginController.checkLogin(null,"admin", "adminaa", null),"redirect:/home");
		assertEquals(loginController.checkLogin(null,"admin1", "admin", null),"index");
	}

}
