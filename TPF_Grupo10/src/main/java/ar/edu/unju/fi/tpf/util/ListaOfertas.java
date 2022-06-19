package ar.edu.unju.fi.tpf.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpf.entity.Oferta;

/**
 * Lista de Ofertas
 * 
 * @author JoaquinCorimayo
 *
 */
@Component
public class ListaOfertas {
	private ArrayList<Oferta> ofertas = new ArrayList<Oferta>();

	public ListaOfertas() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(ArrayList<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

}
