package com.applying.demo.spring.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.applying.demo.spring.bean.InstitucionBean;
import com.applying.demo.spring.bean.PersonaBean;

@Repository("daoInstitucion")
public class DaoInstitucionImpl implements DaoInstitucion{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public String agregarInstitucion(InstitucionBean institucion) throws Exception {
		// TODO Auto-generated method stub
		Connection cn = dataSource.getConnection();
		String rpta = null;
		String procedimientoalmacenado = "{CALL sp_insertarInstitucion(?,?)}";
		if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                cs.setString(1, institucion.getNombre());
                cs.setString(2, institucion.getDireccion());
                int inserto = cs.executeUpdate();
                
                if(inserto == 0){
                    rpta = "Error";
                }
                
                
            } catch (SQLException ex) {
                rpta = ex.getMessage();
            }
            finally {
                try {
                    cn.close();
                } catch (SQLException e){
                    rpta = e.getMessage();
                }
            }
		}
		return rpta;
	}

	@Override
	public InstitucionBean obtenerInstitucion(Long id) throws Exception {
		
		InstitucionBean i = new InstitucionBean();
        String procedimientoalmacenado = "{CALL sp_datosInstitucionPorId(?)}";
        Connection cn = dataSource.getConnection();
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                cs.setLong(1, id);
                ResultSet rs = cs.executeQuery();
                if(rs.next()){
                    
                    i.setId(rs.getLong("id"));
                    i.setNombre(rs.getString("nombre"));
                    i.setDireccion(rs.getString("direccion"));
                   
                    
                }
            } catch (SQLException ex) {}
                finally{
                        try{
                            cn.close();
                        } catch (SQLException e){
                        
                        }
                }
            
        }
        return i;
	}

	@Override
	public String modificarInstitucion(InstitucionBean objInstitucionBean) throws Exception {
		// TODO Auto-generated method stub
		String rpta = null;
        Connection cn =dataSource.getConnection();
        String procedimientoalmacenado = "{CALL sp_actualizarInstitucion(?,?,?)}";
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                cs.setLong(1, objInstitucionBean.getId());
                cs.setString(2, objInstitucionBean.getNombre());
                cs.setString(3, objInstitucionBean.getDireccion());
            
                int actualizo = cs.executeUpdate();
                
                if(actualizo == 0){
                    rpta = "Error";
                }
                
                
            } catch (SQLException ex) {
                rpta = ex.getMessage();
            }
            finally {
                try {
                    cn.close();
                } catch (SQLException e){
                    rpta = e.getMessage();
                }
            }
        }
        return rpta;
		
	}

	@Override
	public String eliminarInstitucion(Long id) throws Exception {
		// TODO Auto-generated method stub
		String rpta = null;
        Connection cn =dataSource.getConnection();
        String procedimientoalmacenado = "{CALL sp_eliminaInstitucion(?)}";
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                    cs.setLong(1, id);
                    cs.executeUpdate();
                
            } catch (SQLException ex) {
                rpta = ex.getMessage();
            }
            finally {
                try {
                    cn.close();
                } catch (SQLException e){
                    rpta = e.getMessage();
                }
            }
        }
        return rpta;
	}

	@Override
	public List<InstitucionBean> obtenerInstituciones() throws Exception {
		// TODO Auto-generated method stub
		List<InstitucionBean> lista = new ArrayList<InstitucionBean>();
        String procedimientoalmacenado = "{CALL sp_listarInstituciones()}";
        Connection cn =dataSource.getConnection();
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                ResultSet rs = cs.executeQuery();
                while(rs.next()){
                    InstitucionBean in= new InstitucionBean();
                    in.setId(rs.getLong("id"));
                    in.setNombre(rs.getString("nombre"));
                    in.setDireccion(rs.getString("direccion"));
               
                    lista.add(in);
                }
            } catch (SQLException ex) {}
                finally{
                        try{
                            cn.close();
                        } catch (SQLException e){
                        
                        }
                }
            
        }
        return lista;
	}

}
