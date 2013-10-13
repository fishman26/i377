package test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ex3.SetupDao;

public class ServletContListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			new SetupDao().createSchema("example.sql");
			new SetupDao().createSchema("schema.sql");
					} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}
}