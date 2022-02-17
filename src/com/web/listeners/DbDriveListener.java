package com.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DbDriveListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String driverName = sce.getServletContext().getInitParameter("driver");

		try {
			Class.forName(driverName);
			System.out.println("driver is loaded...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
