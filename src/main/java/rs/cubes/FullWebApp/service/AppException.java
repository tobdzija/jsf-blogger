package rs.cubes.FullWebApp.service;

import javax.ejb.ApplicationException;

import rs.cubes.FullWebApp.rest.ErrorMessage;


@ApplicationException(rollback = true)
public class AppException extends RuntimeException {
	private ErrorMessage error;
	public AppException(ErrorMessage error) {
		this.error = error;
	}
	public ErrorMessage getError() {
		return error;
	}
	public void setError(ErrorMessage error) {
		this.error = error;
	}
	
}