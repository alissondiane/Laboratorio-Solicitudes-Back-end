package com.applying.demo.spring.bean;

import org.springframework.http.HttpStatus;

public enum SucessMessageEnumPersona {
	MESSAGE_GENERAL_SUCCESS_PERSONA("message.general.success.persona"),
	
	MENSAJE_PERSONA_REGISTRO_EXITO("message.persona.registro.exito"),
	MENSAJE_PERSONA_ACTUALIZACION_EXITO("message.persona.actualizacion.exito"),
	MENSAJE_PERSONA_ELIMINACION_EXITO("message.persona.eliminacion.exito"),
	MENSAJE_PERSONA_BUSQUEDA_EXITO("message.persona.busqueda.exito")
	;

	private Integer idMessage;
	private String codeMessage;
	private String typeMessage;
	private HttpStatus httpStatus;

	SucessMessageEnumPersona(String codeMessage) {
	this.idMessage = 0;
	this.codeMessage = codeMessage;
	this.typeMessage = MessageType.SUCCESS.getTipo();
	this.httpStatus = HttpStatus.OK;
	}

	public static SucessMessageEnumPersona getById(Integer id) {
    for(SucessMessageEnumPersona e : values()) {
        if(e.idMessage.equals(id)) return e;
    }
    return null;
	}

	public Integer idMessage() {
	return idMessage;
	}

	public String codeMessage() {
	return codeMessage;
	}

	public String getTypeMessage() {
	return typeMessage;
	}

	public void setTypeMessage(String typeMessage) {
	this.typeMessage = typeMessage;
	}

	public HttpStatus getHttpStatus() {
	return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
	this.httpStatus = httpStatus;
	}

}
