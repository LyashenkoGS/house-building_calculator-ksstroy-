package ua.ksstroy.logic.worktype;

import ua.ksstroy.logic.material.MaterialData;

import java.util.List;

public class WorkTypeData {

	private Integer id;

	private String name;

	private String description;

	private String measure;

	private Double unitPrice;

	private List<MaterialData> materials;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//TODO add materials
	/*public Set<MaterialData> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<MaterialData> materials) {
		this.materials = materials;
	}*/

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<MaterialData> getMaterials() {
		return materials;
	}

	public void setMaterials(List<MaterialData> materials) {
		this.materials = materials;
	}
}
