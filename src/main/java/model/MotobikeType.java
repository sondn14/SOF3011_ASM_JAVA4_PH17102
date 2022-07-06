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
public class MotobikeType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer typeId;
	
	@Column
	private String typeName;
	
	@OneToMany(mappedBy = "motobikeType",cascade = CascadeType.ALL)
	private List<Motobike> motobikes;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Motobike> getMotobikes() {
		return motobikes;
	}

	public void setMotobikes(List<Motobike> motobikes) {
		this.motobikes = motobikes;
	}

	public MotobikeType() {
		super();
	}

	public MotobikeType(Integer typeId, String typeName, List<Motobike> motobikes) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.motobikes = motobikes;
	}
}
