package com.applying.demo.spring.bean;

public enum MessageType {
	WARNING("warning"),
 	SUCCESS("success");
	private String tipo;
	MessageType(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return this.tipo;
	}		
}
