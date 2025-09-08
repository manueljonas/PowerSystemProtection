package br.ufrn.imd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Bay {
	private int id;
	private String name;

	@Override
	public String toString() {
		return "Bay: " + name +	" {id='" + id + '\'' + '}';
	}
}
