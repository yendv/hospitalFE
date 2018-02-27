/**
 * 
 */
package fpt.frontend;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @author YenDV
 *
 */
@SpringBootApplication
@ImportResource("classpath:application-config.xml")
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration(exclude = {
		SolrAutoConfiguration.class,
		SecurityAutoConfiguration.class
})
public class ServerApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ServerApplication.class);
	}
	
	final static Logger logger = Logger.getLogger(ServerApplication.class);
	
	public static void main(String[] args) {
		/*logger.debug("getWelcome is executed!");
		logger.info("This is an info log entry");
        logger.error("This is an error log entry");*/
		SpringApplication.run(ServerApplication.class, args);
	}
}
