package com.example.CartSystem.CustomException;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ResourceNotFoundException extends Exception {
	
	private String message;
	private String status;
	
	public ResourceNotFoundException(String message,String status) {
		this.message=message;
		this.status=status;
	}

	public String getMessage() {
		return message;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}

	@Override
	public void printStackTrace(PrintStream s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

}
