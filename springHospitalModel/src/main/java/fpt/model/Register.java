package fpt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the register database table.
 * 
 */
@Entity
@Table(name = "register_fe")
public class Register implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_register")
	private Integer idRegister;

	@Column(name="is_confirm")
	private byte isConfirm;

	@Column(name="message_details")
	private String messageDetails;

	@Column(name="register_day")
	private Timestamp registerDay;

	//bi-directional many-to-one association to GuesUser
	@ManyToOne
	@JoinColumn(name="gues_user_id")
	private GuesUser guesUser;

	//bi-directional many-to-one association to Hospital
	@ManyToOne
	@JoinColumn(name="hospital_id")
	private Hospital hospital;

	public Register() {
	}

	public Integer getIdRegister() {
		return this.idRegister;
	}

	public void setIdRegister(Integer idRegister) {
		this.idRegister = idRegister;
	}

	public byte getIsConfirm() {
		return this.isConfirm;
	}

	public void setIsConfirm(byte isConfirm) {
		this.isConfirm = isConfirm;
	}

	public String getMessageDetails() {
		return this.messageDetails;
	}

	public void setMessageDetails(String messageDetails) {
		this.messageDetails = messageDetails;
	}

	public Timestamp getRegisterDay() {
		return this.registerDay;
	}

	public void setRegisterDay(Timestamp registerDay) {
		this.registerDay = registerDay;
	}

	public GuesUser getGuesUser() {
		return this.guesUser;
	}

	public void setGuesUser(GuesUser guesUser) {
		this.guesUser = guesUser;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}