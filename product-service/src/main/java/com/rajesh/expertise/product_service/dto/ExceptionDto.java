package com.rajesh.expertise.product_service.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
	
	private HttpStatus errorCode;
	private String msg;
	
	public ExceptionDto(HttpStatus httpstatus, String message)
	{
		this.errorCode=httpstatus;
		this.msg=message;
	}

}
