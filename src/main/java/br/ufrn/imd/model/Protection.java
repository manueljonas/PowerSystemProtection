package br.ufrn.imd.model;

public interface Protection {
	boolean start();
	boolean trip();
	boolean enable();
	boolean block();
}
