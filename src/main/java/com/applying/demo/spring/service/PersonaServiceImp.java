package com.applying.demo.spring.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.applying.demo.spring.bean.PersonaBean;
import com.applying.demo.spring.bean.SolicitudBean;
import com.applying.demo.spring.bean.SolicitudNumero;
@Service("personaService")
public class PersonaServiceImp implements PersonaService{
	static List<PersonaBean> personas = null;
	static ArrayList<String> solicitudes1 = null;
	static ArrayList<String> solicitudes2 = null;
	static ArrayList<String> solicitudes3 = null;
	static ArrayList<String> solicitudes4 = null;
	
	static {
		personas = new ArrayList<PersonaBean>();
		solicitudes1 = new ArrayList<String>();
		solicitudes2 = new ArrayList<String>();
		solicitudes3 = new ArrayList<String>();
		solicitudes4 = new ArrayList<String>();
		solicitudes1.add("1");
		solicitudes1.add("2");
		solicitudes1.add("3");
		solicitudes2.add("1");
		solicitudes2.add("4");
		solicitudes2.add("2");
		solicitudes3.add("3");
		solicitudes3.add("6");
		solicitudes3.add("5");
		
		
		personas.add(new PersonaBean(1l,"Lucia","45678937",solicitudes1));
		personas.add(new PersonaBean(2l,"Camila","35353436",solicitudes2));
		personas.add(new PersonaBean(3l,"Juan","3534437",solicitudes3));
		personas.add(new PersonaBean(4l,"Jesus","73658367",solicitudes2));
	}

	@Override
	public Long agregarPersona(PersonaBean objPersonaBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonaBean obtenerPersona(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarPersona(PersonaBean objPersonaBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPersona(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonaBean> obtenerPersonas() {
		// TODO Auto-generated method stub
		return personas;
	}
	
	
	

}
