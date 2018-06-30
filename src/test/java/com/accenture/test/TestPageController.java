package com.accenture.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;

import com.accenture.servlets.PageController;

public class TestPageController {
	
	@Test
	public void testGreeting() throws IOException, ServletException {
		PageController pageController = new PageController();						
		assertNotNull(pageController);
	}
	
}
