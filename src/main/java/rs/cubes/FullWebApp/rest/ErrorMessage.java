package rs.cubes.FullWebApp.rest;

public class ErrorMessage {
	private int code;
	private String message;
	private ErrorMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static ErrorMessage ok() {return new ErrorMessage(0,"Sve OK.");}
	public static ErrorMessage usernameTooLong() {return new ErrorMessage(101,"Unet USERNAME ima vise od 20 karaktera.");}
	public static ErrorMessage nameTooLong() {return new ErrorMessage(102,"Unet NAME ima vise od 20 karaktera.");}
	public static ErrorMessage surnameTooLong() {return new ErrorMessage(103,"Unet SURNAME ima vise od 50 karaktera.");}
	public static ErrorMessage nicknameTooLong() {return new ErrorMessage(104,"Unet NICKNAME ima vise od 20 karaktera.");}
	public static ErrorMessage wrongPassword() {return new ErrorMessage(105,"Neispravan password.");}
	public static ErrorMessage emailTooLong() {return new ErrorMessage(106,"Unet USERNAME ima vise od 70 karaktera.");}
	public static ErrorMessage emailFormatError() {return new ErrorMessage(107,"Neispravan format unetog mail-a.");}
	
	
	
}
