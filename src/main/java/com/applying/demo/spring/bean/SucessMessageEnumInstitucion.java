package com.applying.demo.spring.bean;

import org.springframework.http.HttpStatus;

public enum SucessMessageEnumInstitucion {
	MESSAGE_GENERAL_SUCCESS_INSTITUCION("message.general.success.institucion"),
	
	MENSAJE_INSTITUCION_REGISTRO_EXITO("message.institucion.registro.exito"),
	MENSAJE_INSTITUCION_ACTUALIZACION_EXITO("message.institucion.actualizacion.exito"),
	MENSAJE_INSTITUCION_ELIMINACION_EXITO("message.institucion.eliminacion.exito"),
	MENSAJE_INSTITUCION_BUSQUEDA_EXITO("message.institucion.busqueda.exito")
	;

	private Integer idMessage;
	private String codeMessage;
	private String typeMessage;
	private HttpStatus httpStatus;

	SucessMessageEnumInstitucion(String codeMessage) {
	this.idMessage = 0;
	this.codeMessage = codeMessage;
	this.typeMessage = MessageType.SUCCESS.getTipo();
	this.httpStatus = HttpStatus.OK;
	}

	public static SucessMessageEnumInstitucion getById(Integer id) {
    for(SucessMessageEnumInstitucion e : values()) {
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
