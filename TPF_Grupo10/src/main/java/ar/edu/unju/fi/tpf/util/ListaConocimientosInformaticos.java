package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListaConocimientosInformaticos {
	private ArrayList<String> conoInf = new ArrayList<String>();
	
	public ListaConocimientosInformaticos() {
		conoInf.add("Nada");
		conoInf.add("Poco");
		conoInf.add("Medio");
		conoInf.add("Profesional");
	}

	public ArrayList<String> getConoInf() {
		return conoInf;
	}

	public void setConoInf(ArrayList<String> conoInf) {
		this.conoInf = conoInf;
	}
	
}