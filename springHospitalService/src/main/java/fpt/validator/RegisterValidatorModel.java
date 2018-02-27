/**
 * 
 */
package fpt.validator;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import fpt.model.Register;

/**
 * @author YenDV
 *
 */
@MessageEndpoint
public class RegisterValidatorModel {
	@ServiceActivator(inputChannel = "register-channel-3-validate-storage", 
			outputChannel = "register-channel-4-service")
	public Register validateRegister(Register resgister) {
		return resgister;
	}
}
