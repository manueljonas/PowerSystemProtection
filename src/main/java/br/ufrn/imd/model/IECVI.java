package br.ufrn.imd.model;

public class IECVI extends IEC {
	private static final double A = 13.5;
	private static final double K1 = 0;
	private static final double B = 0;
	private static final double K2 = 0;
	private static final double P = 1;
	private static final double Q = 1;

	@Override
	public double timeToOperate() {
		t = ((A * td + K1) / (Math.pow(m, P) - Q)) + B * td + K2;
		return t;
	}

}
