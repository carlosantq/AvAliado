package servico;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener {
	
	@Override
    public void contextInitialized(ServletContextEvent event) {
        System.getProperties().put("org.apache.el.parser.COERCE_TO_ZERO", "false");
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}