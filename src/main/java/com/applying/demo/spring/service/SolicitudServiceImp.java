package com.applying.demo.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applying.demo.spring.bean.PersonaBean;
import com.applying.demo.spring.bean.SolicitudBean;
import com.applying.demo.spring.bean.SolicitudFiltroBean;
import com.applying.demo.spring.dao.DaoPersonaImpl;
import com.applying.demo.spring.dao.DaoSolicitud;
import com.applying.demo.spring.dao.DaoSolicitudImpl;

@Service
public class SolicitudServiceImp implements SolicitudService {
	@Autowired
	DaoSolicitud daoSolicitud ;
	static List<SolicitudBean> solicitudes = null;

	static {
		solicitudes = new ArrayList<SolicitudBean>();
		solicitudes.add(new SolicitudBean(1l,10l,"Comisaria San Juan", 2l,"Juan Manuel",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(2l,11l,"Comisaria Miraflores", 2l,"Juan Manuel",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(3l,12l,"Comisaria Cercado", 3l,"Luis Sandoval",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(4l,13l,"Comisaria Breña", 1l,"Joel Vivanco",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(5l,14l,"Comisaria Comas", 4l,"Marcos Rengifo",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(6l,15l,"Comisaria San Isidro", 5l,"Jose Martinez",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(7l,14l,"Comisaria Comas", 4l,"Marcos Rengifo",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(8l,16l,"Comisaria San Martin", 6l,"Saul Reyes",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(9l,18l,"Comisaria Los Olivos", 8l,"Camila Gutierrez",1l,"REGISTRADO"));
		solicitudes.add(new SolicitudBean(10l,17l,"Comisaria Lince", 7l,"Lucia Davila",1l,"REGISTRADO"));
	}
	
	@Override
	public Long agregarSolicitud(SolicitudBean objSolicitudBean) {		
		/*
		SolicitudBean solicitudMax = Collections.max(solicitudes, Comparator.comparing(c -> c.getId()));
		objSolicitudBean.setId(solicitudMax.getId()+1);
		solicitudes.add(objSolicitudBean);
		return objSolicitudBean.getId();
		*/
		try {
			
			daoSolicitud.agregarSolicitud(objSolicitudBean);
			List <SolicitudBean> lista= daoSolicitud.obtenerSolicitudes();
			SolicitudBean solicitudMax = Collections.max(lista, Comparator.comparing(c -> c.getId()));
			objSolicitudBean.setId(solicitudMax.getId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return objSolicitudBean.getId();
	}
	@Override
	public SolicitudBean obtenerSolicitud(Long id) {
		// TODO Auto-generated method stub
		/*SolicitudBean resSolicitudBean = solicitudes.stream()                        // Convert to steam
                .filter(sol -> id.equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		
		return resSolicitudBean;*/
		SolicitudBean s = null;
		try {
			s = daoSolicitud.obtenerSolicitud(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
	}
	
	@Override
	public void modificarSolicitud(SolicitudBean objSolicitudBean) {
		
		/*
		SolicitudBean resSolicitudBean = solicitudes.stream()                        // Convert to steam
                .filter(sol -> objSolicitudBean.getId().equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		
		resSolicitudBean.setInstitucionNombre(objSolicitudBean.getInstitucionNombre());
		resSolicitudBean.setSolicitanteNombre(objSolicitudBean.getSolicitanteNombre());
		resSolicitudBean.setEstadoNombre(objSolicitudBean.getEstadoNombre());*/
		try {
			daoSolicitud.modificarSolicitud(objSolicitudBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void eliminarSolicitud(Long id) {
		/*
		SolicitudBean resSolicitudBean = solicitudes.stream()                        // Convert to steam
                .filter(sol -> id.equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		if(resSolicitudBean!=null) {
			solicitudes.remove(resSolicitudBean);
		}*/
		
		try {
			daoSolicitud.eliminarSolicitud(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public List<SolicitudBean> obtenerSolicitudes(SolicitudFiltroBean pSolicitudFiltroBean) {
		
		/*
		return solicitudes;
		*/
		List<SolicitudBean> lista = null;
		try {
			lista = daoSolicitud.obtenerSolicitudes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lista.size());
		return lista;
	}
	
	@Override
	public List<SolicitudBean> obtenerSolicitudPorPersona(Long idPersona){
		List<SolicitudBean> solicitudesFiltradas = null;
		List<SolicitudBean> solicitudes=null;
		//Predicate<Person> byAge = person -> person.getAge() > 30;
		try {
			solicitudes = daoSolicitud.obtenerSolicitudes();
			Predicate<SolicitudBean> byidPersona = sol -> idPersona.equals(sol.getSolicitanteId());
	        solicitudesFiltradas = solicitudes.stream().filter(byidPersona).collect(Collectors.<SolicitudBean> toList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return solicitudesFiltradas;
		
	}


	

}
