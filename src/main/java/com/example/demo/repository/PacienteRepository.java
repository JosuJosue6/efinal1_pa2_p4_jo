package com.example.demo.repository;

import com.example.demo.repository.modelo.Paciente;

public interface PacienteRepository {

	public void insertar (Paciente paciente);
	
	public void actualizar (Paciente paciente);
	
	public void eliminarPorCedula (String cedula);
	
	public Paciente seleccionarPorCedula (String cedula);
}
