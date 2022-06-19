package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListaProvincias {
	
	private ArrayList<String> provincias = new ArrayList<String>();
	
	public ListaProvincias() {
		provincias.add("Buenos Aires");
		provincias.add("CABA");
		provincias.add("Catamarca");
		provincias.add("Chaco");
		provincias.add("Chubut");
		provincias.add("Cordoba");
		provincias.add("Corrientes");
		provincias.add("Entre Rios");
		provincias.add("Formosa");
		provincias.add("Jujuy");
		provincias.add("La Pampa");
		provincias.add("La Rioja");
		provincias.add("Mendoza");
		provincias.add("Misiones");
		provincias.add("Río Negro");
		provincias.add("Salta");
		provincias.add("San Juan");
		provincias.add("San Luis");
		provincias.add("Santa Cruz");
		provincias.add("Santa Fe");
		provincias.add("Santiago del Estero");
		provincias.add("Tierra del Fuego");
		provincias.add("Tucumán");	
	}

	public ArrayList<String> getProvincias() {
		return provincias;
	}

	public void setProvincias(ArrayList<String> provincias) {
		this.provincias = provincias;
	}
	
}
