package com.applying.demo.spring.bean;

import java.util.List;

public class ResultMessage {
	Integer code;
	String message;
	String error;
	List<String> messageDetail;
	String type;
	Object data;
	String startDate;
	String endDate;
	
	public ResultMessage(Object data) {
		this.data = data;
	}
	 
	public ResultMessage(SucessMessageEnum messageConstants, String message ) {
		this.code=messageConstants.idMessage();
		this.message=message;
		this.type=messageConstants.getTypeMessage();
	}
	public ResultMessage(ErrorMessageEnum messageConstants, String message ) {
		this.code=messageConstants.idMessage();
		this.message=message;
		this.type=messageConstants.getTypeMessage();
	}
	
	public ResultMessage(ErrorMessageEnum messageConstants,List<String> messageDetail, String message ) {
		this.code=messageConstants.idMessage();
		this.message=message;
		this.type=messageConstants.getTypeMessage();
		this.messageDetail = messageDetail;
	}
	
	public ResultMessage() {
		// TODO Auto-generated constructor stub
	}
	public ResultMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public List<String> getMessageDetail() {
		return messageDetail;
	}
	public void setMessageDetail(List<String> messageDetail) {
		this.messageDetail = messageDetail;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}


}
