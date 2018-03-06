package com.applying.demo.spring.bean;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class SolicitudFiltroBean {
	
	private Long rol;
	private Long solicitudId;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="America/Lima")
	@DateTimeFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date fechaInicio;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="America/Lima")
	@DateTimeFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")	
	private Date fechaFin;
	private List<Long> estado;
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public List<Long> getEstado() {
		return estado;
	}
	public void setEstado(List<Long> estado) {
		this.estado = estado;
	}
	public Long getSolicitudId() {
		return solicitudId;
	}
	public void setSolicitudId(Long solicitudId) {
		this.solicitudId = solicitudId;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Long getRol() {
		return rol;
	}
	public void setRol(Long rol) {
		this.rol = rol;
	}
}
