package com.example.demo.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements CitaMedicaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public void eliminarPorNumeroCita(String numeroCita) {
		// TODO Auto-generated method stub
		CitaMedica citaMedicaEncontrada = this.seleccionarPorNumeroCita(numeroCita);
		this.entityManager.remove(citaMedicaEncontrada);
	}

	@Override
	public CitaMedica seleccionarPorNumeroCita(String numeroCita) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT e FROM CitaMedica e WHERE e.numeroCita = :datoCita");
		myQuery.setParameter("datoCita", numeroCita);
		return (CitaMedica) myQuery.getSingleResult();
	}

	@Override
	public void actualizarPorNumero(String numero, String diagnostico, String receta, LocalDate proximaCita) {
		// TODO Auto-generated method stub
		CitaMedica citaMedica = this.seleccionarPorNumeroCita(numero);
		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setFechaProximaCita(proximaCita);
		citaMedica.setReceta(receta);
		this.actualizar(citaMedica);
	}

}
