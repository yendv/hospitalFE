/**
 * 
 */
package fpt.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import fpt.model.GuesUser;
import fpt.model.Hospital;
import fpt.model.Register;
import fpt.repository.GuesUserRepository;
import fpt.repository.HospitalRepository;
import fpt.repository.RegisterRepository;
import fpt.services.RegisterService;

/**
 * @author YenDV
 *
 */
@MessageEndpoint
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private GuesUserRepository guesRespo;
	
	@Autowired
	private HospitalRepository hospitalRespo;
	
	@Autowired
	private RegisterRepository registerRespo;
	
	@ServiceActivator(inputChannel = "register-channel-4-service")
	public String registerHealing(Register register) {
		if(register.getGuesUser() != null && register.getGuesUser().getIdUser() == null) {
			GuesUser currentUser = (GuesUser)guesRespo.save(register.getGuesUser());
			register.setGuesUser(currentUser);
		}	
		List<Hospital> testList = hospitalRespo.findAll();
		if(testList != null) {
			testList.forEach(item -> {
				System.out.println(item.toString());
			});
		}
		Hospital currentHospital = register.getHospital();
		try {
			if(currentHospital != null) {
				Object currentObj = hospitalRespo.findOne(currentHospital.getIdHospital());
				currentHospital = currentObj == null ? null : (Hospital)hospitalRespo.getOne(currentHospital.getIdHospital());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(currentHospital == null || currentHospital.getIdHospital() <= 0) {
			return "Hospital does not exist. Please contact with admin for update hospital information.";
		}	
		register.setHospital(currentHospital);
		registerRespo.save(register);
		return "success";
	}
}
