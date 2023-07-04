package com.example.demo.repository;

import java.time.LocalDate;

import com.example.demo.repository.modelo.CitaMedica;

public interface CitaMedicaRepository {

	public void insertar (CitaMedica citaMedica);
	
	public void actualizar (CitaMedica citaMedica);
	
	public void eliminarPorNumeroCita(String numeroCita);
	
	public CitaMedica seleccionarPorNumeroCita (String numeroCita);
	
	public void actualizarPorNumero(String numero, String diagnostico, String receta, LocalDate proximaCita);
}
