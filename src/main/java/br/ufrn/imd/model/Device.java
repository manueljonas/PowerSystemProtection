package br.ufrn.imd.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Device {
	private int id;
	private String name;
	private String type;
	private String brand;
	private String model;
	private String serialNumber;

	@Override
	public String toString() {
		return "Device: " + name + " {id='" + id + '\'' + ", type='" + type + '\'' + ", brand='" + brand + '\'' + ", model='"
		+ model + '\'' + ", serialNumber='" + serialNumber + '\'' + '}';
	}
}
