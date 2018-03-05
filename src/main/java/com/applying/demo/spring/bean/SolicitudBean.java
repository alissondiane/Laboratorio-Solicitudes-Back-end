package com.applying.demo.spring.bean;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class SolicitudBean {

	private Long id;
	private Long tipoInstitucionId;
	private String tipoInstitucionNombre;
	private Long institucionId;
	private String institucionNombre;
	private Long solicitanteId;
	private String solicitanteNombre;
	private Long guardiaId;
	private String guardiaNombre;
	private String ubigeoId;
	private String departamentoNombre;
	private String provinciaNombre;
	private String distritoNombre;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="America/Lima")
	@DateTimeFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date solicitudFecha;
	private Long estadoId;
	private String estadoNombre;
	
	private String telefono;

	private String correo;

	private String direccion;

	private String modalidadNombre;
	
	private Double monto;
	private String resumen;
	private Long delitoId;
	private String delitoNombre;
	private String nombreCompletoFiscal;
	private String numeroDocumentoFiscal;
	private List<Long> listaExamenId;
	private Long tipoResultadoId;
	private String tipoResultadoNombre;
	private Long peritoResponsableId;
	private String peritoResponsableNombre;
	private Boolean recibido;
	private String referencia;
	private Boolean requiereAsignacion;
	private Boolean esOficio;
	private String observacion;

	public SolicitudBean() {
		
	}
	public SolicitudBean(Long id, Long institucionId, String institucionNombre, Long solicitanteId,
			String solicitanteNombre, Long estadoId, String estadoDes) {
		super();
		this.id = id;
		this.institucionId = institucionId;
		this.institucionNombre = institucionNombre;
		this.solicitanteId = solicitanteId;
		this.solicitanteNombre = solicitanteNombre;
		this.estadoId = estadoId;
		this.estadoNombre = estadoDes;
	}

	
	public SolicitudBean(Long id, Long institucionId, String institucionNombre, Long solicitanteId,
			String solicitanteNombre, String ubigeoId, String departamentoNombre, String provinciaNombre,
			String distritoNombre, Long estadoId, String estadoDes,Long guardiaId,String guardiaNombre) {
		super();
		this.id = id;
		this.institucionId = institucionId;
		this.institucionNombre = institucionNombre;
		this.solicitanteId = solicitanteId;
		this.solicitanteNombre = solicitanteNombre;
		this.guardiaId = guardiaId;
		this.guardiaNombre = guardiaNombre;
		this.ubigeoId = ubigeoId;
		this.departamentoNombre = departamentoNombre;
		this.provinciaNombre = provinciaNombre;
		this.distritoNombre = distritoNombre;
		this.estadoId = estadoId;
		this.estadoNombre = estadoDes;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getInstitucionId() {
		return institucionId;
	}
	public void setInstitucionId(Long institucionId) {
		this.institucionId = institucionId;
	}
	public String getInstitucionNombre() {
		return institucionNombre;
	}
	public void setInstitucionNombre(String institucionNombre) {
		this.institucionNombre = institucionNombre;
	}
	public Long getSolicitanteId() {
		return solicitanteId;
	}
	public void setSolicitanteId(Long solicitanteId) {
		this.solicitanteId = solicitanteId;
	}
	public String getSolicitanteNombre() {
		return solicitanteNombre;
	}
	public void setSolicitanteNombre(String solicitanteNombre) {
		this.solicitanteNombre = solicitanteNombre;
	}
	public String getUbigeoId() {
		return ubigeoId;
	}
	public void setUbigeoId(String ubigeoId) {
		this.ubigeoId = ubigeoId;
	}
	public String getDepartamentoNombre() {
		return departamentoNombre;
	}
	public void setDepartamentoNombre(String departamentoNombre) {
		this.departamentoNombre = departamentoNombre;
	}
	public String getProvinciaNombre() {
		return provinciaNombre;
	}
	public void setProvinciaNombre(String provinciaNombre) {
		this.provinciaNombre = provinciaNombre;
	}
	public String getDistritoNombre() {
		return distritoNombre;
	}
	public void setDistritoNombre(String distritoNombre) {
		this.distritoNombre = distritoNombre;
	}
	public Long getEstadoId() {
		return estadoId;
	}
	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}
	public String getEstadoNombre() {
		return estadoNombre;
	}
	public void setEstadoNombre(String estadoNombre) {
		this.estadoNombre = estadoNombre;
	}


	public Long getGuardiaId() {
		return guardiaId;
	}


	public void setGuardiaId(Long guardiaId) {
		this.guardiaId = guardiaId;
	}


	public String getGuardiaNombre() {
		return guardiaNombre;
	}


	public void setGuardiaNombre(String guardiaNombre) {
		this.guardiaNombre = guardiaNombre;
	}


	public Date getSolicitudFecha() {
		return solicitudFecha;
	}


	public void setSolicitudFecha(Date solicitudFecha) {
		this.solicitudFecha = solicitudFecha;
	}


	public Long getTipoInstitucionId() {
		return tipoInstitucionId;
	}


	public void setTipoInstitucionId(Long tipoInstitucionId) {
		this.tipoInstitucionId = tipoInstitucionId;
	}


	public String getTipoInstitucionNombre() {
		return tipoInstitucionNombre;
	}


	public void setTipoInstitucionNombre(String tipoInstitucionNombre) {
		this.tipoInstitucionNombre = tipoInstitucionNombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getModalidadNombre() {
		return modalidadNombre;
	}


	public void setModalidadNombre(String modalidadNombre) {
		this.modalidadNombre = modalidadNombre;
	}


	public Double getMonto() {
		return monto;
	}


	public void setMonto(Double monto) {
		this.monto = monto;
	}


	public String getResumen() {
		return resumen;
	}


	public void setResumen(String resumen) {
		this.resumen = resumen;
	}


	public Long getDelitoId() {
		return delitoId;
	}


	public void setDelitoId(Long delitoId) {
		this.delitoId = delitoId;
	}


	public String getDelitoNombre() {
		return delitoNombre;
	}


	public void setDelitoNombre(String delitoNombre) {
		this.delitoNombre = delitoNombre;
	}


	public String getNombreCompletoFiscal() {
		return nombreCompletoFiscal;
	}


	public void setNombreCompletoFiscal(String nombreCompletoFiscal) {
		this.nombreCompletoFiscal = nombreCompletoFiscal;
	}

	public String getNumeroDocumentoFiscal() {
		return numeroDocumentoFiscal;
	}


	public void setNumeroDocumentoFiscal(String numeroDocumentoFiscal) {
		this.numeroDocumentoFiscal = numeroDocumentoFiscal;
	}


	public List<Long> getListaExamenId() {
		return listaExamenId;
	}


	public void setListaExamenId(List<Long> listaExamenId) {
		this.listaExamenId = listaExamenId;
	}


	public Long getTipoResultadoId() {
		return tipoResultadoId;
	}


	public void setTipoResultadoId(Long tipoResultadoId) {
		this.tipoResultadoId = tipoResultadoId;
	}


	public Long getPeritoResponsableId() {
		return peritoResponsableId;
	}


	public void setPeritoResponsableId(Long peritoResponsableId) {
		this.peritoResponsableId = peritoResponsableId;
	}


	public String getPeritoResponsableNombre() {
		return peritoResponsableNombre;
	}


	public void setPeritoResponsableNombre(String peritoResponsableNombre) {
		this.peritoResponsableNombre = peritoResponsableNombre;
	}


	public Boolean getRecibido() {
		return recibido;
	}

	public void setRecibido(Boolean recibido) {
		this.recibido = recibido;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Boolean getRequiereAsignacion() {
		return requiereAsignacion;
	}

	public void setRequiereAsignacion(Boolean requiereAsignacion) {
		this.requiereAsignacion = requiereAsignacion;
	}

	public Boolean getEsOficio() {
		return esOficio;
	}

	public void setEsOficio(Boolean esOficio) {
		this.esOficio = esOficio;
	}



	public String getTipoResultadoNombre() {
		return tipoResultadoNombre;
	}


	public void setTipoResultadoNombre(String tipoResultadoNombre) {
		this.tipoResultadoNombre = tipoResultadoNombre;
	}


	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}


	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
