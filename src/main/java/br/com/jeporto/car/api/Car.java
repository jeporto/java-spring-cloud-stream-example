package br.com.jeporto.car.api;

public class Car {

	private Long id;

	private String name;

	private String model;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", model=" + model + "]";
	}
}