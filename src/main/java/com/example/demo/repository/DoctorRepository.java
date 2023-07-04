package com.example.demo.repository;

import com.example.demo.repository.modelo.Doctor;

public interface DoctorRepository {

	public void insertar (Doctor doctor);
	
	public void actualizar (Doctor doctor);
	
	public void eliminarPorCedula (String cedula);
	
	public Doctor seleccionarPorCedula (String cedula);
}
