package com.applying.demo.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.applying.demo.spring.bean.SolicitudBean;
import com.applying.demo.spring.bean.SolicitudFiltroBean;

@Service
public class SolicitudServiceImp implements SolicitudService {
	static List<SolicitudBean> solicitudes = null;

	static {
		solicitudes = new ArrayList<SolicitudBean>();
		solicitudes.add(new SolicitudBean(1l,10l,"Comisaria San Juan", 100l,"Juan Manuel",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(2l,11l,"Comisaria Miraflores", 101l,"José Martinez",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(3l,12l,"Comisaria Cercado", 102l,"Luis Sandoval",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(4l,13l,"Comisaria Breña", 103l,"Joel Vivanco",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(5l,14l,"Comisaria Comas", 104l,"Marcos Rengifo",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(6l,15l,"Comisaria San Isidro", 105l,"Saul Reyes",1l,"REGISTRADO"));
	}
	
	@Override
	public Long agregarSolicitud(SolicitudBean objSolicitudBean) {		
		SolicitudBean solicitudMax = Collections.max(solicitudes, Comparator.comparing(c -> c.getId()));
		objSolicitudBean.setId(solicitudMax.getId()+1);
		solicitudes.add(objSolicitudBean);
		return objSolicitudBean.getId();
	}
	
	@Override
	public void modificarSolicitud(SolicitudBean objSolicitudBean) {		
		SolicitudBean resSolicitudBean = solicitudes.stream()                        // Convert to steam
                .filter(sol -> objSolicitudBean.getId().equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		
		resSolicitudBean.setInstitucionNombre(objSolicitudBean.getInstitucionNombre());
		resSolicitudBean.setSolicitanteNombre(objSolicitudBean.getSolicitanteNombre());
		resSolicitudBean.setEstadoNombre(objSolicitudBean.getEstadoNombre());
	}

	@Override
	public List<SolicitudBean> obtenerSolicitudes(SolicitudFiltroBean pSolicitudFiltroBean) {
		return solicitudes;
	}

	@Override
	public SolicitudBean obtenerSolicitud(Long id) {
		// TODO Auto-generated method stub
		SolicitudBean resSolicitudBean = solicitudes.stream()                        // Convert to steam
                .filter(sol -> id.equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		
		return resSolicitudBean;
		
	}

	@Override
	public void eliminarSolicitud(Long id) {
		SolicitudBean resSolicitudBean = solicitudes.stream()                        // Convert to steam
                .filter(sol -> id.equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		if(resSolicitudBean!=null) {
			solicitudes.remove(resSolicitudBean);
		}
	}


}
