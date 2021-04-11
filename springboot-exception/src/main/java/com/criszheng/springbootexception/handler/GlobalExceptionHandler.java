package com.criszheng.springbootexception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.criszheng.springbootexception.exception.ErrorMsg;
import com.criszheng.springbootexception.exception.SessionNotFoundException;

/**
 * @author Cris
 * @date 11 Apr 2021
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(SessionNotFoundException.class)
	public ErrorMsg<String> sessionNotFoundExceptionHandler(HttpServletRequest request, SessionNotFoundException exception) throws Exception{
		return handleErrorInfo(request,exception.getMessage(),exception);
	}

	private ErrorMsg<String> handleErrorInfo(HttpServletRequest request, String message,
			SessionNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMsg<String> errorMessage = new ErrorMsg<>();
        errorMessage.setMessage(message);
        errorMessage.setCode(ErrorMsg.ERROR);
        errorMessage.setData(message);
        errorMessage.setUrl(request.getRequestURL().toString());
		return errorMessage;
	}
}
