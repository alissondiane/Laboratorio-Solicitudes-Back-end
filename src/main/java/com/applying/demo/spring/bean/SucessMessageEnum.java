package com.applying.demo.spring.bean;



import org.springframework.http.HttpStatus;


public enum SucessMessageEnum {

	MESSAGE_GENERAL_SUCCESS("message.general.success"),
	
	MENSAJE_SOLICITUD_REGISTRO_EXITO("message.solicitud.registro.exito"),
	MENSAJE_SOLICITUD_ACTUALIZACION_EXITO("message.solicitud.actualizacion.exito"),
	MENSAJE_SOLICITUD_ELIMINACION_EXITO("message.solicitud.eliminacion.exito"),
	MENSAJE_SOLICITUD_BUSQUEDA_EXITO("message.solicitud.busqueda.exito")
	;
	
	

	private Integer idMessage;
	private String codeMessage;
	private String typeMessage;
	private HttpStatus httpStatus;
	
	SucessMessageEnum(String codeMessage) {
		this.idMessage = 0;
		this.codeMessage = codeMessage;
		this.typeMessage = MessageType.SUCCESS.getTipo();
		this.httpStatus = HttpStatus.OK;
	}
	
	public static SucessMessageEnum getById(Integer id) {
	    for(SucessMessageEnum e : values()) {
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
