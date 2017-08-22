package corso.spring.ee.demo.ws.basic.endpoints;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER, customFaultCode = "my Annotated Exception")
public class MyAnnotatedException extends RuntimeException {

	public MyAnnotatedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);		
	}

	public MyAnnotatedException(String message, Throwable cause) {
		super(message, cause);	
	}

	public MyAnnotatedException(String message) {
		super(message);		
	}

	public MyAnnotatedException(Throwable cause) {
		super(cause);		
	}

}
