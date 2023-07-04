package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.CitaMedicaService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PacienteService;

@SpringBootApplication
public class Efinal1Pa2P4JoApplication implements CommandLineRunner{
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private CitaMedicaService citaMedicaService;

	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P4JoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Creacion Doctor 
		Doctor doctor1 = new Doctor();
		doctor1.setCedula("1720525516");
		doctor1.setNombre("Josue");
		doctor1.setApellido("Ocapana");
		doctor1.setFechaNacimiento(LocalDate.of(2000, 01, 06));
		doctor1.setNumeroConsultorio("69");
		doctor1.setCodigoSenescyt("777-AAA");
		doctor1.setGenero("Masculino");
		
		//Ingreso Doctor
		this.doctorService.agregar(doctor1);
		
		//Crear Paciente
		Paciente paciente1 = new Paciente();
		paciente1.setCedula("123456");
		paciente1.setNombre("Luis");
		paciente1.setApellido("Perenguez");
		paciente1.setFechaNacimiento(LocalDate.of(1998, 06, 28));
		paciente1.setCodigoSeguro("555-BBB");
		paciente1.setEstatura(175);
		paciente1.setPeso(150.0);
		paciente1.setGenero("No binario");

		//ingresar paciente
		this.pacienteService.agregar(paciente1);
		
		//crear cita con numero cita, fecha, valor, lugar, cedula doctor, cedula paciente
		CitaMedica citaMedica1 = new CitaMedica();
		citaMedica1.setNumeroCita("6");
		citaMedica1.setFechaCita(LocalDate.of(2023, 10, 10));
		citaMedica1.setValorCita(new BigDecimal(50));
		citaMedica1.setLugarCita("Quitumbe");
		citaMedica1.setDoctor(this.doctorService.buscarPorCedula("1720525516"));
		citaMedica1.setPaciente(this.pacienteService.buscarPorCedula("123456"));
	
		//agendar cita medica
		this.citaMedicaService.agendar(citaMedica1);
		
		//datos para actualizacion de la cita
		String diagnostico = "Fiebre mayor de 40 grados";
		String receta = "Tomar paracetamol cada 8 horas";
			
		//actualizar cita medica
		this.citaMedicaService.actualizarPorNumero("6", diagnostico, receta, LocalDate.of(2023, 12, 10));

	}

}
