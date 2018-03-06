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

import com.applying.demo.spring.bean.PersonaBean;
import com.applying.demo.spring.bean.ResultMessage;
import com.applying.demo.spring.bean.SolicitudBean;
import com.applying.demo.spring.bean.SucessMessageEnumPersona;
import com.applying.demo.spring.service.PersonaService;


@RestController
public class RestPersonaController {

	@Autowired
	private PersonaService personaService;

	@Autowired
	private MessageSource msg; 
	
	@RequestMapping(value="/persona", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> obtenerPersonas(Locale objLocale) throws Exception{
		
		ResultMessage response = new ResultMessage(SucessMessageEnumPersona.MESSAGE_GENERAL_SUCCESS_PERSONA);
		response.setData(personaService.obtenerPersonas());
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnumPersona.MESSAGE_GENERAL_SUCCESS_PERSONA.getHttpStatus());
	}

	@RequestMapping(value="/persona/{id}", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> obtenerPersona(@PathVariable("id") Long personaId, Locale objLocale) throws Exception{
		ResultMessage response = new ResultMessage(SucessMessageEnumPersona.MESSAGE_GENERAL_SUCCESS_PERSONA);
		response.setData(personaService.obtenerPersona(personaId));
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnumPersona.MESSAGE_GENERAL_SUCCESS_PERSONA.getHttpStatus());
	}	
	
	@RequestMapping(value="/persona", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> guardarPersona(@RequestBody PersonaBean pPersonaBean , Errors errors , Locale objLocale) throws Exception{        
		Long personaId = personaService.agregarPersona(pPersonaBean);
		String message = msg.getMessage(SucessMessageEnumPersona.MENSAJE_PERSONA_REGISTRO_EXITO.codeMessage(),new Object[] {personaId} , objLocale);
		ResultMessage response = new ResultMessage(SucessMessageEnumPersona.MENSAJE_PERSONA_REGISTRO_EXITO,message);
		response.setData(personaId);
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnumPersona.MENSAJE_PERSONA_REGISTRO_EXITO.getHttpStatus());
	}

	@RequestMapping(value="/persona/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> actualizarPersona(@PathVariable("id") Long personaId,@RequestBody PersonaBean objPersonaBean, Locale objLocale) throws Exception{
		objPersonaBean.setId(personaId);
		personaService.modificarPersona(objPersonaBean);
		String message = msg.getMessage(SucessMessageEnumPersona.MENSAJE_PERSONA_ACTUALIZACION_EXITO.codeMessage(),new Object[] {objPersonaBean.getId()} , objLocale);
		ResultMessage response = new ResultMessage(SucessMessageEnumPersona.MENSAJE_PERSONA_ACTUALIZACION_EXITO,message);
		response.setData(objPersonaBean.getId());
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnumPersona.MENSAJE_PERSONA_ACTUALIZACION_EXITO.getHttpStatus());
	}
	
	@RequestMapping(value="/persona/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> eliminarPersona(@PathVariable("id") Long personaId, Locale objLocale) throws Exception{
		personaService.eliminarPersona(personaId);
		String message = msg.getMessage(SucessMessageEnumPersona.MENSAJE_PERSONA_ACTUALIZACION_EXITO.codeMessage(),new Object[] {personaId} , objLocale);
		ResultMessage response = new ResultMessage(SucessMessageEnumPersona.MENSAJE_PERSONA_ACTUALIZACION_EXITO,message);
		response.setData(personaId);
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnumPersona.MENSAJE_PERSONA_ACTUALIZACION_EXITO.getHttpStatus());
	}	
}
