package fpt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the gues_user database table.
 * 
 */
@Entity
@Table(name="gues_user_fe")
public class GuesUser implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/*@Column(name="id_user")*/
	private Integer idUser;

	@Column(name="birth_gues_user")
	private Timestamp birthdayUser;

	@Column(name="code_user")
	private String codeUser;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="person_number")
	private String personNumber;

	private String phone;

	@Column(name="register_date")
	private Timestamp registerDate;

	public GuesUser() {
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Timestamp getBirthdayUser() {
		return this.birthdayUser;
	}

	public void setBirthdayUser(Timestamp birthdayUser) {
		this.birthdayUser = birthdayUser;
	}

	public String getCodeUser() {
		return this.codeUser;
	}

	public void setCodeUser(String codeUser) {
		this.codeUser = codeUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonNumber() {
		return this.personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

}