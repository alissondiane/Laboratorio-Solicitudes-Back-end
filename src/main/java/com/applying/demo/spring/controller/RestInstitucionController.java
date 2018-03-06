package com.applying.demo.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.applying.demo.spring.bean.InstitucionBean;
import com.applying.demo.spring.bean.PersonaBean;
import com.applying.demo.spring.bean.ResultMessage;
import com.applying.demo.spring.bean.SucessMessageEnumInstitucion;
import com.applying.demo.spring.bean.SucessMessageEnumPersona;
import com.applying.demo.spring.service.InstitucionService;
import com.applying.demo.spring.service.PersonaService;

@RestController
public class RestInstitucionController {
	@Autowired
	private InstitucionService institucionService;

	@Autowired
	private MessageSource msg; 
	
	@RequestMapping(value="/institucion", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> obtenerInstituciones(Locale objLocale) throws Exception{
		
		ResultMessage response = new ResultMessage(SucessMessageEnumInstitucion.MESSAGE_GENERAL_SUCCESS_INSTITUCION);
		response.setData(institucionService.obtenerInstituciones());
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnumInstitucion.MESSAGE_GENERAL_SUCCESS_INSTITUCION.getHttpStatus());
	}

	@RequestMapping(value="/institucion/{id}", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> obtenerPersona(@PathVariable("id") Long institucionId, Locale objLocale) throws Exception{
		ResultMessage response = new ResultMessage(SucessMessageEnumInstitucion.MESSAGE_GENERAL_SUCCESS_INSTITUCION);
		response.setData(institucionService.obtenerInstitucion(institucionId));
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnumInstitucion.MESSAGE_GENERAL_SUCCESS_INSTITUCION.getHttpStatus());
	}	
	
	@RequestMapping(value="/institucion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> guardarPersona(@RequestBody InstitucionBean pInstitucionBean , Errors errors , Locale objLocale) throws Exception{        
		Long personaId = institucionService.agregarInstitucion(pInstitucionBean);
		String message = msg.getMessage(SucessMessageEnumInstitucion.MENSAJE_INSTITUCION_REGISTRO_EXITO.codeMessage(),new Object[] {personaId } , objLocale);
		ResultMessage response = new ResultMessage(SucessMessageEnumInstitucion.MENSAJE_INSTITUCION_REGISTRO_EXITO,message);
		response.setData(personaId);
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnumPersona.MENSAJE_PERSONA_REGISTRO_EXITO.getHttpStatus());
	}

	@RequestMapping(value="/institucion/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> actualizarPersona(@PathVariable("id") Long institucionId,@RequestBody InstitucionBean objInstitucionBean, Locale objLocale) throws Exception{
		objInstitucionBean.setId(institucionId);
		institucionService.modificarInstitucion(objInstitucionBean);
		String message = msg.getMessage(SucessMessageEnumInstitucion.MENSAJE_INSTITUCION_ACTUALIZACION_EXITO.codeMessage(),new Object[] {objInstitucionBean.getId()} , objLocale);
		ResultMessage response = new ResultMessage(SucessMessageEnumInstitucion.MENSAJE_INSTITUCION_ACTUALIZACION_EXITO,message);
		response.setData(objInstitucionBean.getId());
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnumInstitucion.MENSAJE_INSTITUCION_ACTUALIZACION_EXITO.getHttpStatus());
	}
	
	@RequestMapping(value="/institucion/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> eliminarPersona(@PathVariable("id") Long institucionId, Locale objLocale) throws Exception{
		institucionService.eliminarInstitucion(institucionId);
		String message = msg.getMessage(SucessMessageEnumInstitucion.MENSAJE_INSTITUCION_ACTUALIZACION_EXITO.codeMessage(),new Object[] {institucionId} , objLocale);
		ResultMessage response = new ResultMessage(SucessMessageEnumInstitucion.MENSAJE_INSTITUCION_ACTUALIZACION_EXITO,message);
		response.setData(institucionId);
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnumInstitucion.MENSAJE_INSTITUCION_ACTUALIZACION_EXITO.getHttpStatus());
	}	
}
