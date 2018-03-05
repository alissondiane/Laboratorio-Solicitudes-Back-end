package com.applying.demo.spring.service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applying.demo.spring.bean.PersonaBean;
import com.applying.demo.spring.dao.DaoPersona;
import com.applying.demo.spring.dao.DaoPersonaImpl;

@Service("personaService")
public class PersonaServiceImp implements PersonaService{
	@Autowired
	DaoPersona daoPersona ;
	
	static List<PersonaBean> personas = null;

	
	static {
		personas = new ArrayList<PersonaBean>();
		
		personas.add(new PersonaBean(1l,"Joel","Vivanco","76279643"));
		personas.add(new PersonaBean(2l,"Juan","Manuel","35353436"));
		personas.add(new PersonaBean(3l,"Luis","Sandoval","3534437"));
		personas.add(new PersonaBean(4l,"Marcos","Rengifo","73658367"));
		personas.add(new PersonaBean(5l,"Jose","Martinez","76279570"));
		personas.add(new PersonaBean(6l,"Saul","Reyes","73658998"));
		personas.add(new PersonaBean(7l,"Lucia","Davila","74597253"));
		personas.add(new PersonaBean(8l,"Camila","Gutierrez","74597253"));
	}

	@Override
	public Long agregarPersona(PersonaBean objPersonaBean){	
		
		
		/*PersonaBean solicitudMax = Collections.max(personas, Comparator.comparing(c -> c.getId()));
		objPersonaBean.setId(solicitudMax.getId()+1);
		personas.add(objPersonaBean);
		return objPersonaBean.getId();*/
		try {
			daoPersona.agregarPersona(objPersonaBean);
			List <PersonaBean> lista= daoPersona.obtenerPersonas();
			PersonaBean solicitudMax = Collections.max(lista, Comparator.comparing(c -> c.getId()));
			objPersonaBean.setId(solicitudMax.getId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return objPersonaBean.getId();
	}
	
	@Override
	public void modificarPersona(PersonaBean objPersonaBean) {
		
		try {
			daoPersona.modificarPersona(objPersonaBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		PersonaBean resPersonaBean = personas.stream()                        // Convert to steam
                .filter(sol -> objPersonaBean.getId().equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		
		resPersonaBean.setNombre(objPersonaBean.getNombre());
		resPersonaBean.setApellido(objPersonaBean.getApellido());
		resPersonaBean.setDni(objPersonaBean.getDni());*/
	}

	@Override
	public List<PersonaBean> obtenerPersonas() {
		List<PersonaBean> lista = null;
		try {
			lista = daoPersona.obtenerPersonas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public PersonaBean obtenerPersona(Long id) {
		PersonaBean p = null;
		try {
			p = daoPersona.obtenerPersona(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		// TODO Auto-generated method stub
		
		/*PersonaBean resPersonaBean = personas.stream()                        // Convert to steam
                .filter(sol -> id.equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		
		return resPersonaBean;*/
		
	}

	@Override
	public void eliminarPersona(Long id) {
		try {
			daoPersona.eliminarPersona(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		PersonaBean resPersonaBean = personas.stream()                        // Convert to steam
                .filter(sol -> id.equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		if(resPersonaBean!=null) {
			personas.remove(resPersonaBean);
		}*/
	}


	
	

}
