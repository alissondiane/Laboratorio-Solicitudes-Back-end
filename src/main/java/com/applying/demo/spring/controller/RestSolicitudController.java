package com.applying.demo.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.applying.demo.spring.bean.ResultMessage;
import com.applying.demo.spring.bean.SolicitudBean;
import com.applying.demo.spring.bean.SolicitudFiltroBean;
import com.applying.demo.spring.bean.SucessMessageEnum;
import com.applying.demo.spring.service.SolicitudService;

@RestController
public class RestSolicitudController {

	@Autowired
	private SolicitudService solicitudService;

	@Autowired
	private MessageSource msg; 
	
	@RequestMapping(value="/solicitud", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> obtenerSolicitudes(@ModelAttribute SolicitudFiltroBean pSolicitudFiltroBean, Locale objLocale) throws Exception{
		System.out.println(pSolicitudFiltroBean.getFechaInicio());
		System.out.println(pSolicitudFiltroBean.getFechaFin());
		
		ResultMessage response = new ResultMessage(SucessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		response.setData(solicitudService.obtenerSolicitudes(pSolicitudFiltroBean));
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
	
	@RequestMapping(value="/solicitud/{id}", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> obtenerSolicitud(@PathVariable("id") Long solicitudId, Locale objLocale) throws Exception{
		ResultMessage response = new ResultMessage(SucessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		response.setData(solicitudService.obtenerSolicitud(solicitudId));
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}	
	
	@RequestMapping(value="/solicitud", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> guardarSolicitud(@RequestBody SolicitudBean pSolicitudBean , Errors errors , Locale objLocale) throws Exception{        
		Long solicitudId = solicitudService.agregarSolicitud(pSolicitudBean);
		String message = msg.getMessage(SucessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO.codeMessage(),new Object[] {solicitudId } , objLocale);
		ResultMessage response = new ResultMessage(SucessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO,message);
		response.setData(solicitudId);
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO.getHttpStatus());
	}

	@RequestMapping(value="/solicitud/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> actualizarSolicitud(@PathVariable("id") Long solicitudId,@RequestBody SolicitudBean objSolicitudBean, Locale objLocale) throws Exception{
		objSolicitudBean.setId(solicitudId);
		solicitudService.modificarSolicitud(objSolicitudBean);
		String message = msg.getMessage(SucessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO.codeMessage(),new Object[] {objSolicitudBean.getId()} , objLocale);
		ResultMessage response = new ResultMessage(SucessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO,message);
		response.setData(objSolicitudBean.getId());
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO.getHttpStatus());
	}
	
	@RequestMapping(value="/solicitud/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> actualizarSolicitud(@PathVariable("id") Long solicitudId, Locale objLocale) throws Exception{
		solicitudService.eliminarSolicitud(solicitudId);
		String message = msg.getMessage(SucessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO.codeMessage(),new Object[] {solicitudId} , objLocale);
		ResultMessage response = new ResultMessage(SucessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO,message);
		response.setData(solicitudId);
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO.getHttpStatus());
	}	

}
