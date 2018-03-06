package com.applying.demo.spring.dao;

import java.util.List;

import com.applying.demo.spring.bean.SolicitudBean;

public interface DaoSolicitud {
	
	public String agregarSolicitud(SolicitudBean solicitud) throws Exception;
	   
	   public SolicitudBean obtenerSolicitud(Long id)throws Exception;
	   
	   public String modificarSolicitud(SolicitudBean objSolicitudBean) throws Exception;
	   
	   public String eliminarSolicitud(Long id)throws Exception;

	   public List<SolicitudBean> obtenerSolicitudes() throws Exception;
}
