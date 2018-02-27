/**
 * 
 */
package fpt.frontend.validation;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import fpt.frontend.request.RegisterRequest;


/**
 * @author YenDV
 *
 */
@MessageEndpoint
public class RegisterValidator {
	@ServiceActivator(inputChannel = "register-channel-1-validate-input" , 
			outputChannel = "register-channel-2-transform")
	public RegisterRequest validateRequest(RegisterRequest request) {
		return request;
	}
}
