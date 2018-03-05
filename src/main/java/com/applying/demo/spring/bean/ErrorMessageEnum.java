package com.applying.demo.spring.bean;

import org.springframework.http.HttpStatus;

public enum ErrorMessageEnum {

	// Mantenimiento Usuario 1-99
	
	
	NOT_FOUNT_USER_ACCOUNT(3,MessageType.WARNING.getTipo(),"message.usuario.noencontrado",HttpStatus.NOT_FOUND)	
	;

	private Integer idMessage;
	private String codeMessage;
	private String typeMessage;
	private HttpStatus httpStatus;
	
	ErrorMessageEnum(Integer idMessage, String typeMessage,String codeMessage,HttpStatus httpStatus) {
		this.idMessage = idMessage;
		this.codeMessage = codeMessage;
		this.typeMessage = typeMessage;
		this.httpStatus = httpStatus;
	}
	
	public static ErrorMessageEnum getById(Integer id) {
	    for(ErrorMessageEnum e : values()) {
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
