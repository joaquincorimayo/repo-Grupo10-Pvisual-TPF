package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListaDisponibilidad {
	private ArrayList<String> disponibilidad = new ArrayList<String>();

	public ListaDisponibilidad() {
		disponibilidad.add("Mañana");
		disponibilidad.add("Tarde");
		disponibilidad.add("Fines de semana");
	}

	public ArrayList<String> getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(ArrayList<String> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

}
