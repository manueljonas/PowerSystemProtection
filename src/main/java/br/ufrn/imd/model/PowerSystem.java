package br.ufrn.imd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PowerSystem {
	private int id;
	private String name;
	private String location;
	
	@Override
	public String toString() {
		return "PowerSystem: " + name + " {id='" + id + '\'' + ", location='" + location + '\'' + '}';
	}
}
