package nhom15.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.NotFound;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler({NotFound.class,NullPointerException.class})
	public String error404(Exception ex) {
	//	ex.printStackTrace();
		ex.getMessage();
		return "exception/Error404";
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public String IllegalArgumentException(Exception ex) {
		ex.printStackTrace();
		return "exception/Error404";
	}
	@ExceptionHandler(Exception.class)
	public String exception(Exception ex) {
		ex.printStackTrace();
		return "exception/Error500";
	} 
}
