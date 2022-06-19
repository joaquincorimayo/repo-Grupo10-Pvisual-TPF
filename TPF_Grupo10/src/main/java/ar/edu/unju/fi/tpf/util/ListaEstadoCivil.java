package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListaEstadoCivil {
	private ArrayList<String> estadoCivil = new ArrayList<String>();
	
	public ListaEstadoCivil() {
		estadoCivil.add("Solero");
		estadoCivil.add("Casado");
		estadoCivil.add("Divorciado");
		estadoCivil.add("Viudo");
	}

	public ArrayList<String> getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(ArrayList<String> estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
}
