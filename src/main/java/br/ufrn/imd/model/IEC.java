package br.ufrn.imd.model;

public class IEC implements ElementTimeCharacteristic {
	protected double m;
	protected double td;
	protected double t;

	public IEC() {
		// Metodo construtor vazio
	}

	public void setM(double m) {
		this.m = m;
	}

	public void setTd(double td) {
		if (td >= 0) {
			this.td = td;
		} else {
			this.td = 0;
		}
	}

	@Override
	public double timeToOperate() {
		t = td;
		return t;
	}

}
