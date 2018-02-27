/**
 * 
 */
package fpt.frontend.transform;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import fpt.common.CommonUtils;
import fpt.frontend.request.RegisterRequest;
import fpt.model.GuesUser;
import fpt.model.Hospital;
import fpt.model.Register;


/**
 * @author YenDV
 *
 */
@MessageEndpoint
public class RegisterTransform {
	@ServiceActivator(inputChannel = "register-channel-2-transform" ,
			outputChannel = "register-channel-3-validate-storage")
	public Register transform(RegisterRequest request) {
		Register convertRegister = new Register();
		Hospital hospitalRegister = new Hospital();
		hospitalRegister.setIdHospital(CommonUtils.convertToInteger(request.getIdHospital()));
		convertRegister.setHospital(hospitalRegister);
		GuesUser userRegiter = new GuesUser();
		userRegiter.setFirstName(request.getFirstName());
		userRegiter.setLastName(request.getLastName());
		userRegiter.setPersonNumber(request.getPersonNumber());
		convertRegister.setGuesUser(userRegiter);
		//convertRegister.setRegisterDay(registerDay);
		return convertRegister;
	}
}
