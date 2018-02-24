package com.applying.demo.spring.service;

import java.util.List;

import com.applying.demo.spring.bean.SolicitudBean;
import com.applying.demo.spring.bean.SolicitudFiltroBean;

public interface SolicitudService {
	
   public Long agregarSolicitud(SolicitudBean objSolicitudBean);
   
   public SolicitudBean obtenerSolicitud(Long id);
   
   public void modificarSolicitud(SolicitudBean objSolicitudBean) ;
   
   public void eliminarSolicitud(Long id);

   public List<SolicitudBean> obtenerSolicitudes(SolicitudFiltroBean pSolicitudFiltroBean);
   
}
