package ar.edu.unju.fi.tpf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpf.entity.Empleador;

/**
 * Declaracion de servicios para Empleador.
 * 
 * @author JoaquinCorimayo
 */

@Service
public interface IEmpleadorService {
	public Empleador crearEmpleador();

	public void guardarEmpleador(Empleador empleador);

	public void borrarEmpleador(Long id);

	public void actualizarEmpleador(Empleador empleador);

	public List<Empleador> listarEmpleadores();

	public Empleador buscarEmpleador(Long id);
}