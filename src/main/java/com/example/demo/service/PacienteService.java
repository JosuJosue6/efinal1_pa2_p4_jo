package com.example.demo.service;

import com.example.demo.repository.modelo.Paciente;

public interface PacienteService {
	
	public void agregar (Paciente paciente);
	
	public void actualizar (Paciente paciente);
	
	public void borrarPorCedula (String cedula);
	
	public Paciente buscarPorCedula (String cedula);
}
