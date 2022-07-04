package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListaJornada {
	private ArrayList<String> jornada = new ArrayList<String>();

	public ListaJornada() {
		jornada.add("Full-Time");
		jornada.add("Part-Time");
	}

	public ArrayList<String> getJornada() {
		return jornada;
	}

	public void setJornada(ArrayList<String> jornada) {
		this.jornada = jornada;
	}

}
