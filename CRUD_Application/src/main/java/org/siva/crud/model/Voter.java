package org.siva.crud.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the voters database table.
 * 
 */
@Entity
@Table(name="voters")
@NamedQuery(name="Voter.findAll", query="SELECT v FROM Voter v")
public class Voter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="voter_id")
	private Integer voterId;

	@Column(name="voter_address")
	private String voterAddress;

	@Column(name="voter_age")
	private int voterAge;

	@Column(name="voter_gender")
	private String voterGender;

	@Column(name="voter_mobile", unique=true)
	private String voterMobile;

	@Column(name="voter_name")
	private String voterName;

	public Voter() {
	}

	public Integer getVoterId() {
		return this.voterId;
	}

	public void setVoterId(Integer voterId) {
		this.voterId = voterId;
	}

	public String getVoterAddress() {
		return this.voterAddress;
	}

	public void setVoterAddress(String voterAddress) {
		this.voterAddress = voterAddress;
	}

	public int getVoterAge() {
		return this.voterAge;
	}

	public void setVoterAge(int voterAge) {
		this.voterAge = voterAge;
	}

	public String getVoterGender() {
		return this.voterGender;
	}

	public void setVoterGender(String voterGender) {
		this.voterGender = voterGender;
	}

	public String getVoterMobile() {
		return this.voterMobile;
	}

	public void setVoterMobile(String voterMobile) {
		this.voterMobile = voterMobile;
	}

	public String getVoterName() {
		return this.voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	@Override
	public String toString() {
		return "Voter [voterId=" + voterId + ", voterAddress=" + voterAddress + ", voterAge=" + voterAge
				+ ", voterGender=" + voterGender + ", voterMobile=" + voterMobile + ", voterName=" + voterName + "]";
	}

}