package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DoctorRepositoryImpl implements DoctorRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
	}

	@Override
	public void eliminarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Doctor doctorEncontrado = this.seleccionarPorCedula(cedula);
		this.entityManager.remove(doctorEncontrado);
	}

	@Override
	public Doctor seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Doctor e WHERE e.cedula = :datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Doctor) myQuery.getSingleResult();
	}

}
