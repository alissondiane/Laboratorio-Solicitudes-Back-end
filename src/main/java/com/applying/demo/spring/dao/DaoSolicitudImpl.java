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

import com.applying.demo.spring.bean.PersonaBean;
import com.applying.demo.spring.bean.SolicitudBean;

@Repository("daoSolicitud")
public class DaoSolicitudImpl implements DaoSolicitud {
	@Autowired
	private DataSource dataSource;

	@Override
	public String agregarSolicitud(SolicitudBean solicitud) throws Exception {
		// TODO Auto-generated method stub

				Connection cn = dataSource.getConnection();
				String rpta = null;
				String procedimientoalmacenado = "{CALL sp_insertarSolicitud(?,?,?,?,?,?)}";
				if(cn != null){
		            try{
		                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
		                cs.setLong(1, solicitud.getInstitucionId());
		                cs.setString(2,solicitud.getInstitucionNombre());
		                cs.setLong(3, solicitud.getSolicitanteId());
		                cs.setString(4, solicitud.getSolicitanteNombre());
		                cs.setLong(5, solicitud.getEstadoId());
		                cs.setString(6, solicitud.getEstadoNombre());
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
	public SolicitudBean obtenerSolicitud(Long id) throws Exception {
		// TODO Auto-generated method stub
		
		SolicitudBean p= new SolicitudBean();
        String procedimientoalmacenado = "{CALL sp_datosSolicitudPorId(?)}";
        Connection cn = dataSource.getConnection();
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                cs.setLong(1, id);
                ResultSet rs = cs.executeQuery();
                if(rs.next()){
                	p.setId(rs.getLong("id"));
                    p.setInstitucionId(rs.getLong("institucionId"));
                    p.setInstitucionNombre(rs.getString("institucionNombre"));
                    p.setSolicitanteId(rs.getLong("solicitanteId"));
                    p.setSolicitanteNombre(rs.getString("solicitanteNombre"));
                    p.setEstadoId(rs.getLong("estadoId"));
                    p.setEstadoNombre(rs.getString("estadoNombre"));
                    
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
	public String modificarSolicitud(SolicitudBean objSolicitudBean) throws Exception {
		// TODO Auto-generated method stub
		String rpta = null;
        Connection cn =dataSource.getConnection();
        String procedimientoalmacenado = "{CALL sp_actualizarSolicitud(?,?,?,?,?,?,?)}";
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                cs.setLong(1, objSolicitudBean.getId());
                cs.setLong(2, objSolicitudBean.getInstitucionId());
                cs.setString(3, objSolicitudBean.getInstitucionNombre());
                cs.setLong(4, objSolicitudBean.getSolicitanteId());
                cs.setString(5, objSolicitudBean.getSolicitanteNombre());
                cs.setLong(6, objSolicitudBean.getEstadoId());
                cs.setString(7, objSolicitudBean.getEstadoNombre());
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
	public String eliminarSolicitud(Long id) throws Exception {
		// TODO Auto-generated method stub
		
		String rpta = null;
        Connection cn =dataSource.getConnection();
        String procedimientoalmacenado = "{CALL sp_eliminaSolicitud(?)}";
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
	public List<SolicitudBean> obtenerSolicitudes() throws Exception {
		// TODO Auto-generated method stub
		
		List<SolicitudBean> lista = new ArrayList<SolicitudBean>();
        String procedimientoalmacenado = "{CALL sp_listarSolicitudes()}";
        Connection cn =dataSource.getConnection();
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                ResultSet rs = cs.executeQuery();
                while(rs.next()){
                    SolicitudBean s= new SolicitudBean();
                    s.setId(rs.getLong("id"));
                    s.setInstitucionId(rs.getLong("institucionId"));
                    s.setInstitucionNombre(rs.getString("institucionNombre"));
                    s.setSolicitanteId(rs.getLong("solicitanteId"));
                    s.setSolicitanteNombre(rs.getString("solicitanteNombre"));
                    s.setEstadoId(rs.getLong("estadoId"));
                    s.setEstadoNombre(rs.getString("estadoNombre"));
                    lista.add(s);
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
