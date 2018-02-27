/**
 * 
 */
package fpt.frontend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fpt.frontend.ServerApplication;
import fpt.frontend.gateway.RegisterGateway;
import fpt.frontend.request.RegisterRequest;

/**
 * @author YenDV
 *
 */
@RestController
@RequestMapping(value = "/api")
public class RegisterController {
	@Autowired
	RegisterGateway registerGateway;
	
	final static Logger logger = Logger.getLogger(RegisterController.class);
	
	@RequestMapping(value = "/test" , method = RequestMethod.GET)
	public ResponseEntity<String> test(){
		try {
			return new ResponseEntity<String>("ahihi" ,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("errors" ,HttpStatus.BAD_GATEWAY);
		}
	}
	
	@RequestMapping(value = "/registermedicalexamination", method = RequestMethod.POST)
	public ResponseEntity<String> registerMedicalExamination(@RequestBody RegisterRequest request){
		try {
			return new ResponseEntity<String>(registerGateway.regiesterExamination(request)
					,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("errors" ,HttpStatus.BAD_GATEWAY);
		}
	}
}
