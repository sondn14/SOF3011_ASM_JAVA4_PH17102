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
public class MotobikeColor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer colorId;
	
	@Column
	private String colorName;
	
	@OneToMany(mappedBy = "motobikeColor",cascade = CascadeType.ALL)
	private List<Motobike> motobike;

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public List<Motobike> getMotobike() {
		return motobike;
	}

	public void setMotobike(List<Motobike> motobike) {
		this.motobike = motobike;
	}

	public MotobikeColor() {
		super();
	}

	public MotobikeColor(Integer colorId, String colorName, List<Motobike> motobike) {
		this.colorId = colorId;
		this.colorName = colorName;
		this.motobike = motobike;
	}
}
