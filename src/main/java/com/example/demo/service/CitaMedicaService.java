package com.example.demo.service;

import java.time.LocalDate;

import com.example.demo.repository.modelo.CitaMedica;

public interface CitaMedicaService {

	public void agendar (CitaMedica citaMedica);
	
	public void actualizar (CitaMedica citaMedica);
	
	public void cancelarPorNumeroCita(String numeroCita);
	
	public CitaMedica buscarPorNumeroCita (String numeroCita);
	
	public void actualizarPorNumero(String numero, String diagnostico, String receta, LocalDate proximaCita);
	
	
}
