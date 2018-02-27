package fpt.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hospital database table.
 * 
 */
@Entity
@Table(name = "hospital_fe")
public class Hospital implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_hospital")
	private Integer idHospital;

	@Column(name="code_hospital")
	private String codeHospital;

	@Column(name="confirm_api_link")
	private String confirmApiLink;

	@Column(name="name_hospital")
	private String nameHospital;
	
	@Column(name="active_begin")
	private String activeBegin;
	
	@Column(name="address")
	private String address;
	
	@Column(name="active_end")
	private String activeEnd;

	public Hospital() {
	}

	public Integer getIdHospital() {
		return this.idHospital;
	}

	public void setIdHospital(Integer idHospital) {
		this.idHospital = idHospital;
	}

	public String getCodeHospital() {
		return this.codeHospital;
	}

	public void setCodeHospital(String codeHospital) {
		this.codeHospital = codeHospital;
	}

	public String getConfirmApiLink() {
		return this.confirmApiLink;
	}

	public void setConfirmApiLink(String confirmApiLink) {
		this.confirmApiLink = confirmApiLink;
	}

	public String getNameHospital() {
		return this.nameHospital;
	}

	public void setNameHospital(String nameHospital) {
		this.nameHospital = nameHospital;
	}

	public String getActiveBegin() {
		return activeBegin;
	}

	public void setActiveBegin(String activeBegin) {
		this.activeBegin = activeBegin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getActiveEnd() {
		return activeEnd;
	}

	public void setActiveEnd(String activeEnd) {
		this.activeEnd = activeEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHospital == null) ? 0 : idHospital.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (idHospital == null) {
			if (other.idHospital != null)
				return false;
		} else if (!idHospital.equals(other.idHospital))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hospital [idHospital=" + idHospital + ", codeHospital=" + codeHospital + ", confirmApiLink="
				+ confirmApiLink + ", nameHospital=" + nameHospital + "]";
	}
	
	
}