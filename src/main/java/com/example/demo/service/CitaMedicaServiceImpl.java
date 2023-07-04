package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CitaMedicaRepository;
import com.example.demo.repository.modelo.CitaMedica;



@Service
public class CitaMedicaServiceImpl implements CitaMedicaService{

	@Autowired
	private CitaMedicaRepository citaMedicaRepository;
	
	@Override
	public void agendar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.insertar(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.actualizar(citaMedica);
	}

	@Override
	public void cancelarPorNumeroCita(String numeroCita) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.eliminarPorNumeroCita(numeroCita);
	}

	@Override
	public CitaMedica buscarPorNumeroCita(String numeroCita) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepository.seleccionarPorNumeroCita(numeroCita);
	}


	@Override
	public void actualizarPorNumero(String numero, String diagnostico, String receta, LocalDate proximaCita) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.actualizarPorNumero(numero, diagnostico, receta, proximaCita);
	}

}