package corso.spring.ee.demo.ws.basic.service.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


//@SoapFault(faultCode = FaultCode.SERVER)
public class ServiceException extends Exception {

	public ServiceException(String cause){
		super(cause);
	}
}
