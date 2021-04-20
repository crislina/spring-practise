package com.criszheng.springbootjparediscache.utils;

/**
 * @author Cris
 * @date 24 Nov 2020
 * @version 1.0
 */

public class CommonResult<T> {
	private long code;
	private String message;
	private T data;
	
	private CommonResult() {
	}
	
	private CommonResult(long code,String message,T data) {
		this.code=code;
		this.message=message;
		this.data=data;
	}
	
	public static<T> CommonResult<T> success(){
		return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),null);
	}
	
	public static<T> CommonResult<T> success(T data){
		return new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
	}
	
	public static<T> CommonResult<T> success(T data, String message){
		return new CommonResult<T>(ResultCode.SUCCESS.getCode(),message,data);
	}
	
	public static<T> CommonResult<T> failed(IErrorCode errorCode){
		return new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(),null);
	}
	
	public static<T> CommonResult<T> failed(String message){
		return new CommonResult<T>(ResultCode.FAILED.getCode(),message,null);
	}
	
	public static<T> CommonResult<T> failed(){
		return failed(ResultCode.FAILED);
	}
	
	public static<T> CommonResult<T> badRequest(){
		return failed(ResultCode.BAD_REQUEST);
	}
	
	public static<T> CommonResult<T> badRequest(String message){
		return new CommonResult<T>(ResultCode.BAD_REQUEST.getCode(),message,null);
	}
	
	public static<T> CommonResult<T> unauthorized(T data){
		return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(),data);
	}
	
	public static<T> CommonResult<T> forbidden(T data){
		return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(),data);
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
