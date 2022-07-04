package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListaTareas {
	private ArrayList<String> tareas = new ArrayList<String>();

	public ListaTareas() {
		tareas.add("Compras");
		tareas.add("Ventas");
		tareas.add("Administración");
		tareas.add("Contabilidad");
		tareas.add("Auditoría");
		tareas.add("Desarrollo");
	}

	public ArrayList<String> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<String> tareas) {
		this.tareas = tareas;
	}

}
