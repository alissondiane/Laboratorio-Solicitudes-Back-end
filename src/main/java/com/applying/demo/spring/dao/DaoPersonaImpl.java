package com.applying.demo.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.applying.demo.spring.bean.PersonaBean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Repository("daoPersona")
public class DaoPersonaImpl implements DaoPersona{
	@Autowired
	private DataSource dataSource;
	
	@Override
	public String agregarPersona(PersonaBean persona) throws SQLException{
		// TODO Auto-generated method stub
		Connection cn = dataSource.getConnection();
		String rpta = null;
		String procedimientoalmacenado = "{CALL sp_insertarPersona(?,?,?)}";
		if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                cs.setString(1, persona.getNombre());
                cs.setString(2, persona.getApellido());
                cs.setString(3, persona.getDni());
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
		
/*
		String sql="INSERT INTO persona (id,nombre,apellido,dni) values(?,?,?,?)";
		Connection con = null;
		try {
			con= dataSource.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setDouble(1,persona.getId());
			ps.setString(2,persona.getNombre());
			ps.setString(3,persona.getApellido());
			ps.setString(4,persona.getDni());
			ps.executeUpdate();
			ps.close();
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			if(con!= null) {
				con.close();
			}
		}
		
	}*/
	}
	
	@Override
	public PersonaBean obtenerPersona(Long id) throws Exception {
		// TODO Auto-generated method stub
		
		PersonaBean p= new PersonaBean();
        String procedimientoalmacenado = "{CALL sp_datosPersonaPorId(?)}";
        Connection cn = dataSource.getConnection();
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                cs.setLong(1, id);
                ResultSet rs = cs.executeQuery();
                if(rs.next()){
                    
                    p.setId(rs.getLong("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setApellido(rs.getString("apellido"));
                    p.setDni(rs.getString("dni"));
                    
                }
            } catch (SQLException ex) {}
                finally{
                        try{
                            cn.close();
                        } catch (SQLException e){
                        
                        }
                }
            
        }
        return p;
	}
	@Override
	public String modificarPersona(PersonaBean objPersonaBean) throws Exception {
		// TODO Auto-generated method stub
		
		String rpta = null;
        Connection cn =dataSource.getConnection();
        String procedimientoalmacenado = "{CALL sp_actualizarPersona(?,?,?,?)}";
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                cs.setLong(1, objPersonaBean.getId());
                cs.setString(2, objPersonaBean.getNombre());
                cs.setString(3, objPersonaBean.getApellido());
                cs.setString(4, objPersonaBean.getDni());
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
	public String eliminarPersona(Long id) throws Exception {
		// TODO Auto-generated method stub
		String rpta = null;
        Connection cn =dataSource.getConnection();
        String procedimientoalmacenado = "{CALL sp_eliminaPersona(?)}";
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
	public List<PersonaBean> obtenerPersonas() throws Exception{
		List<PersonaBean> lista = new ArrayList<PersonaBean>();
        String procedimientoalmacenado = "{CALL sp_listarPersonas()}";
        Connection cn =dataSource.getConnection();
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                ResultSet rs = cs.executeQuery();
                while(rs.next()){
                    PersonaBean alu= new PersonaBean();
                    alu.setId(rs.getLong("id"));
                    alu.setNombre(rs.getString("nombre"));
                    alu.setApellido(rs.getString("apellido"));
                    alu.setDni(rs.getString("dni"));
                    lista.add(alu);
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
