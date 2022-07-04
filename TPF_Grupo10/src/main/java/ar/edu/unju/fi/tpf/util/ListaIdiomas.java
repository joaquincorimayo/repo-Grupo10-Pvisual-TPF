package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListaIdiomas {

	private ArrayList<String> idiomas = new ArrayList<String>();
	
	public ListaIdiomas() {
		idiomas.add("Español");
		idiomas.add("Ingles");
		idiomas.add("Frances");
		idiomas.add("Mandarin");
		idiomas.add("Portugues");
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}
	
}
