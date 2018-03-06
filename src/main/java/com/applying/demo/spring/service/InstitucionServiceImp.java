package com.applying.demo.spring.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applying.demo.spring.bean.InstitucionBean;
import com.applying.demo.spring.bean.PersonaBean;
import com.applying.demo.spring.dao.DaoInstitucion;


@Service("institucionService")
public class InstitucionServiceImp implements InstitucionService{
	@Autowired
	DaoInstitucion daoInstitucion ;
	@Override
	public Long agregarInstitucion(InstitucionBean objInstitucionBean) {
		// TODO Auto-generated method stub
		try {
			
			daoInstitucion.agregarInstitucion(objInstitucionBean);
			List <InstitucionBean> lista= daoInstitucion.obtenerInstituciones();
			InstitucionBean solicitudMax = Collections.max(lista, Comparator.comparing(c -> c.getId()));
			objInstitucionBean.setId(solicitudMax.getId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return objInstitucionBean.getId();
	}

	@Override
	public InstitucionBean obtenerInstitucion(Long id) {
		// TODO Auto-generated method stub
		InstitucionBean p = null;
		try {
			p = daoInstitucion.obtenerInstitucion(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void modificarInstitucion(InstitucionBean objInstitucionBean) {
		// TODO Auto-generated method stub
		try {
			daoInstitucion.modificarInstitucion(objInstitucionBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminarInstitucion(Long id) {
		// TODO Auto-generated method stub
		try {
			daoInstitucion.eliminarInstitucion(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<InstitucionBean> obtenerInstituciones() {
		// TODO Auto-generated method stub
		List<InstitucionBean> lista = null;
		try {
			lista = daoInstitucion.obtenerInstituciones();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

}
