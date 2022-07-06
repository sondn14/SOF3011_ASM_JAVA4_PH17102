package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class MotobikeCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	
	@Column
	private String companyName;
	
	@OneToMany(mappedBy = "motobikeCompany",cascade = CascadeType.ALL)
	private List<Motobike> motobikes;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Motobike> getMotobikes() {
		return motobikes;
	}

	public void setMotobikes(List<Motobike> motobikes) {
		this.motobikes = motobikes;
	}

	public MotobikeCompany() {
		super();
	}

	public MotobikeCompany(Integer companyId, String companyName, List<Motobike> motobikes) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.motobikes = motobikes;
	}
}
