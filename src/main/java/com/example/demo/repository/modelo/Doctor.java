package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")//entidad principal
public class Doctor {

	@Id
	@GeneratedValue(generator = "seq_doctor", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_doctor",sequenceName = "seq_doctor", allocationSize = 1)
	@Column(name = "doc_id")
	private Integer id;
	
	@Column(name = "doc_cedula")
	private String cedula;
	
	@Column(name = "doc_nombre")
	private String nombre;
			
	@Column(name = "doc_apellido")
	private String apellido;
	
	@Column(name = "doc_fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name = "doc_numero_consultorio")
	private String numeroConsultorio;
	
	@Column(name = "doc_codigo_senescyt")
	private String codigoSenescyt;
	
	@Column(name = "doc_genero")
	private String genero;
	
	@OneToMany(mappedBy = "doctor")
	private List<CitaMedica> citasMedicas;

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(String numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	public String getCodigoSenescyt() {
		return codigoSenescyt;
	}

	public void setCodigoSenescyt(String codigoSenescyt) {
		this.codigoSenescyt = codigoSenescyt;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<CitaMedica> getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(List<CitaMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", numeroConsultorio=" + numeroConsultorio
				+ ", codigoSenescyt=" + codigoSenescyt + ", genero=" + genero + "]";
	}

	
}
