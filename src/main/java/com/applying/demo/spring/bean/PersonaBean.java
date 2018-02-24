package com.applying.demo.spring.bean;

import java.util.ArrayList;
import java.util.List;

public class PersonaBean {
	Long id;
	String nombre;
	String dni;
	ArrayList<String> solicitudes = null;
	
	
	public PersonaBean(Long id, String nombre, String dni, ArrayList<String> solicitudes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.solicitudes = solicitudes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public ArrayList<String> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(ArrayList<String> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	
}
