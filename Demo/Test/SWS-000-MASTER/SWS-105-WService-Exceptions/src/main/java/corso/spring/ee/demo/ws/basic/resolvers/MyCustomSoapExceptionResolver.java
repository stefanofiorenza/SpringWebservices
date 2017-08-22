package corso.spring.ee.demo.ws.basic.resolvers;

import javax.xml.namespace.QName;

import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

public class MyCustomSoapExceptionResolver extends SoapFaultMappingExceptionResolver {

	private static final QName CODE = new QName("myCustomCode");  	
	
	
	@Override
	protected void customizeFault(Object endpoint, Exception ex,org.springframework.ws.soap.SoapFault fault) {
		SoapFaultDetail detail = fault.addFaultDetail();  
		detail.addFaultDetailElement(CODE).addText("A more detailed message");  		   
		super.customizeFault(endpoint, ex, fault);
	}  
	
	
	
	
//	@Override  
//	protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {  
//	    logger.warn("Exception processed ",ex);  
//	    if (ex instanceof EndpointException) {  
//	        EndpointException ee = (EndpointException) ex;  
//	        SoapFaultDetail detail = fault.addFaultDetail();  
//	        detail.addFaultDetailElement(CODE).addText(ee.getCode());  
//	        detail.addFaultDetailElement(SUB_CODE).addText(ee.getSubCode());  
//	    }  
//	}  
}
