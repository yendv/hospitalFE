package fpt.frontend.request;

public class RegisterRequest {
	private String firstName;
	private String lastName;
	private String personNumber;
	private String dateRegister;
	private String detailsMessage;
	private String idHospital;
	private String test;
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}
	public String getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(String dateRegister) {
		this.dateRegister = dateRegister;
	}
	public String getDetailsMessage() {
		return detailsMessage;
	}
	public void setDetailsMessage(String detailsMessage) {
		this.detailsMessage = detailsMessage;
	}
	public String getIdHospital() {
		return idHospital;
	}
	public void setIdHospital(String idHospital) {
		this.idHospital = idHospital;
	}
	
	
}
