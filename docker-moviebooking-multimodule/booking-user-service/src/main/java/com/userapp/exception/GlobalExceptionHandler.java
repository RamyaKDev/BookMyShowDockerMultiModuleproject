package com.userapp.exception;



import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.userapp.model.ApiErrors;




@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp=LocalDateTime.now();
		int statusCode=status.value();
		String errorMessage=ex.getMessage();
		HttpStatus httpStatus=HttpStatus.METHOD_NOT_ALLOWED;
		ApiErrors apierrors=new ApiErrors(timestamp,statusCode,errorMessage,httpStatus);
		return ResponseEntity.status(httpStatus).body(apierrors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp=LocalDateTime.now();
		int statusCode=status.value();
		String errorMessage=ex.getMessage();
		HttpStatus httpStatus=HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		ApiErrors apierrors=new ApiErrors(timestamp,statusCode,errorMessage,httpStatus);
		return ResponseEntity.status(httpStatus).body(apierrors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value();
		String errorMessage = ex.getMessage();
		HttpStatus httpStatus= HttpStatus.INTERNAL_SERVER_ERROR;
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,errorMessage,httpStatus);
		return ResponseEntity.status(httpStatus).body(apiErrors);

	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value();
		String errorMessage = ex.getMessage();
		HttpStatus httpStatus= HttpStatus.INTERNAL_SERVER_ERROR;
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,errorMessage,httpStatus);
		return ResponseEntity.status(httpStatus).body(apiErrors);

	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = status.value();
		String errorMessage = ex.getMessage();
		HttpStatus httpStatus= HttpStatus.BAD_REQUEST;
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,errorMessage,httpStatus);
		return ResponseEntity.status(httpStatus).body(apiErrors);

	}
	@ExceptionHandler(UserNotFoundException.class)
	ResponseEntity<ApiErrors> handleException(UserNotFoundException e){
		LocalDateTime timestamp = LocalDateTime.now();
		int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
		String errorMessage = e.getMessage();
		HttpStatus httpStatus= HttpStatus.INTERNAL_SERVER_ERROR;
		ApiErrors apiErrors = new ApiErrors(timestamp,statusCode,errorMessage,httpStatus);
		return ResponseEntity.status(httpStatus).body(apiErrors);
	}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
    	 ex.printStackTrace();
        return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
    }
}

