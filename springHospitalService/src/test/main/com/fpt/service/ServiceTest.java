/**
 * 
 */
package main.com.fpt.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fpt.model.Hospital;
import fpt.model.Student;
import fpt.repository.HospitalRepository;

/**
 * @author YenDV
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@SpringBootApplication
@ImportResource("classpath:application-config.xml")
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class })
public class ServiceTest {
	final static Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Test
	public void testService() {
		Hospital hospital = new Hospital();
		
		hospital.setNameHospital("tesst11231231");
		//hospital.setIdHospital(33);
		try {
			hospitalRepository.save(hospital);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Hospital> hospitalAlls = hospitalRepository.findAll();
		hospitalAlls.forEach(item-> {
			System.out.println(item.toString());
		});
		System.out.println("hihi");
		
		
		/*Student testStudent = new Student();
		testStudent.setFirstName("yendv1");
		testStudent.setLastName("yendv1");
		testStudent.setSection("test1");
		try {
			hospitalRepository.save(testStudent);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
