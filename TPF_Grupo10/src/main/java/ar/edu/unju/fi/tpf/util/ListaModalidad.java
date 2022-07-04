package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListaModalidad {
	private ArrayList<String> modalidad = new ArrayList<String>();
	
	public ListaModalidad() {
		modalidad.add("Presencial");
		modalidad.add("Virtual");
	}

	public ArrayList<String> getModalidad() {
		return modalidad;
	}

	public void setModalidad(ArrayList<String> modalidad) {
		this.modalidad = modalidad;
	}
	
}
