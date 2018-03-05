package com.applying.demo.spring.dao;

import java.util.List;

import com.applying.demo.spring.bean.PersonaBean;

public interface DaoPersona {
	public String agregarPersona(PersonaBean persona) throws Exception;
	   
	public PersonaBean obtenerPersona(Long id)throws Exception;
	   
	public String modificarPersona(PersonaBean objPersonaBean) throws Exception;
	   
	public String eliminarPersona(Long id)throws Exception;

	public List<PersonaBean> obtenerPersonas() throws Exception;
}
