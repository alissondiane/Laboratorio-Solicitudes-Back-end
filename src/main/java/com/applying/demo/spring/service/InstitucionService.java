package com.applying.demo.spring.service;

import java.util.List;

import com.applying.demo.spring.bean.InstitucionBean;
import com.applying.demo.spring.bean.PersonaBean;

public interface InstitucionService {
	public Long agregarInstitucion( InstitucionBean objInstitucionBean);
	   
	   public InstitucionBean obtenerInstitucion(Long id);
	   
	   public void modificarInstitucion( InstitucionBean  objInstitucionBean) ;
	   
	   public void eliminarInstitucion(Long id);

	   public List< InstitucionBean> obtenerInstituciones();
}
