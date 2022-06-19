package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpf.entity.Empleador;

/**
 * Lista de empleadores
 * 
 * @author JoaquinCorimayo
 *
 */

@Component
public class ListaEmpleadores {
	
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	
	public ListaEmpleadores() {
		
	}

	public ArrayList<Empleador> getEmpleadores() {
		return empleadores;
	}

	public void setEmpleadores(ArrayList<Empleador> empleadores) {
		this.empleadores = empleadores;
	}
	
}
