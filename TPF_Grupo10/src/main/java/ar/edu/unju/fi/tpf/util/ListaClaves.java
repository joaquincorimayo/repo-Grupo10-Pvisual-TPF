package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListaClaves {
	private ArrayList<String> claves = new ArrayList<String>();

	public ListaClaves() {
		claves.add("Administracion de redes y sistema"); 
		claves.add("Ciencia de datos"); 
		claves.add("Computacion en la nuve"); 
		claves.add("Desarrollo de software"); 
		claves.add("Desarrollo movil"); 
		claves.add("Desarrollo web"); 
		claves.add("DevOps"); 
		claves.add("Gestion de base de datos"); 
		claves.add("Seguridad informatica");
		claves.add("Servicio tecnico");
	}

	public ArrayList<String> getClaves() {
		return claves;
	}

	public void setClaves(ArrayList<String> claves) {
		this.claves = claves;
	}
}
