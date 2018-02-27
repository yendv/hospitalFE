/**
 * 
 */
package fpt.frontend.response;

/**
 * @author YenDV
 *
 */
public class ResgiterResponse {
	private String activeMessage;
	private String statusRequest;
	private String examinationDay;
	private String examinationAdrress;
	private String deadline;
	
	public String getActiveMessage() {
		return activeMessage;
	}
	public void setActiveMessage(String activeMessage) {
		this.activeMessage = activeMessage;
	}
	public String getStatusRequest() {
		return statusRequest;
	}
	public void setStatusRequest(String statusRequest) {
		this.statusRequest = statusRequest;
	}
	public String getExaminationDay() {
		return examinationDay;
	}
	public void setExaminationDay(String examinationDay) {
		this.examinationDay = examinationDay;
	}
	public String getExaminationAdrress() {
		return examinationAdrress;
	}
	public void setExaminationAdrress(String examinationAdrress) {
		this.examinationAdrress = examinationAdrress;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	
}
