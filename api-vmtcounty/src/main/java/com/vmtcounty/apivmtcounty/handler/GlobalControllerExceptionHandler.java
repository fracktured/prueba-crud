package com.vmtcounty.apivmtcounty.handler;

import java.time.LocalDateTime;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vmtcounty.apivmtcounty.exception.VmtCountyIdInUseException;
import com.vmtcounty.apivmtcounty.exception.VmtCountyNotFoundException;
import com.vmtcounty.apivmtcounty.response.ErrorResponse;

@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ConversionFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConnversion(RuntimeException ex, WebRequest request) {
		return this.createResponseEntity(HttpStatus.BAD_REQUEST, ex, request);
    }
	
	@ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleNumberFormat(RuntimeException ex, WebRequest request) {
        Exception exception = new Exception("Debe ingresar un número válido. " + ex.getMessage());
        return this.createResponseEntity(HttpStatus.BAD_REQUEST, exception, request);
    }
   
    @ExceptionHandler(VmtCountyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleVmtCountyNotFound(RuntimeException ex, WebRequest request) {
    	return this.createResponseEntity(HttpStatus.NOT_FOUND, ex, request);
    }
    
    @ExceptionHandler(VmtCountyIdInUseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleVmtCountyIdInUse(RuntimeException ex, WebRequest request) {
    	return this.createResponseEntity(HttpStatus.BAD_REQUEST, ex, request);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Exception exception = new Exception(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return this.createResponseEntity(HttpStatus.BAD_REQUEST, exception, request);
    }

    private ResponseEntity<Object> createResponseEntity(HttpStatus httpStatus, Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
        		LocalDateTime.now(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(true));
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), httpStatus, request);
    }
}
