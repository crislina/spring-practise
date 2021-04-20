package com.criszheng.springbootjparediscache.utils;

/**
 * @author Cris
 * @date 24 Nov 2020
 * @version 1.0
 */

public enum ResultCode implements IErrorCode {
	/**
     * Http.OK
     */
	SUCCESS(200,"OK"),
	/**
     * Http.Internal_Server_Error
     */
	FAILED(500,"Internal Server Error"),
	/**
     * Http.Bad_Request
     */
	BAD_REQUEST(400,"Bad Request"),
	/**
     * Http.Unauthorized
     */
	UNAUTHORIZED(401,"Unauthorized"),
	/**
     * Http.Forbidden
     */
	FORBIDDEN(403,"Forbidden")
	;
	private Long code;
	private String message;
	
	private ResultCode(long code, String message) {
		this.code=code;
		this.message=message;
	}

	@Override
	public long getCode() {
		// TODO Auto-generated method stub
		return this.code;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}

}
