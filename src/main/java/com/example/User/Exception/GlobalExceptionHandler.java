//package com.example.User.Exception;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.example.User.Model.DataResponse;
//
//@ControllerAdvice
//public class GlobalExceptionHandler extends Throwable {
//	
//	private static final long serialVersionUID = 1L;
//
//	@ExceptionHandler(Throwable.class)
//	@ResponseBody
//	public DataResponse handlerControllerException (FileStorageException e) {
//		DataResponse dataResponse = new DataResponse();
//		dataResponse.setError(true);
//		dataResponse.setMessage(e.getMessage());
//		dataResponse.setCauseError(e.getMessage());
//		return dataResponse;
//	}
//	
//	
//
//}
