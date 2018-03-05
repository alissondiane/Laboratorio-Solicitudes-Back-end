package com.applying.demo.spring.dao;

import java.util.List;

import com.applying.demo.spring.bean.InstitucionBean;
import com.applying.demo.spring.bean.PersonaBean;

public interface DaoInstitucion {
	public String agregarInstitucion(InstitucionBean institucion) throws Exception;
	   
	public InstitucionBean obtenerInstitucion(Long id)throws Exception;
	   
	public String modificarInstitucion(InstitucionBean objInstitucionBean) throws Exception;
	   
	public String eliminarInstitucion(Long id)throws Exception;

	public List<InstitucionBean> obtenerInstituciones() throws Exception;
}
