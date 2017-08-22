package corso.spring.ee.demo.ws.basic.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.soap.axiom.AxiomSoapMessageFactory;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import corso.spring.ee.demo.ws.basic.endpoints.MyAnnotatedException;
import corso.spring.ee.demo.ws.basic.resolvers.MyCustomSoapExceptionResolver;
import corso.spring.ee.demo.ws.basic.service.exceptions.ServiceException;


/**
 * 
 * @author s.fiorenza
 *
 *Versione con annotations di spring-ws-servlet.xml
 */

@EnableWs
@Configuration
@ComponentScan(basePackages = { "corso.spring.ee.demo.ws.basic.endpoints" })
public class WsContextConfig {

	 @Bean
	 public AxiomSoapMessageFactory messageFactory() {
	    return new AxiomSoapMessageFactory();
	 }
	 
	 
	 
	 
	 @Bean
	 public SoapFaultMappingExceptionResolver exceptionResolver(){
		 
		 	SoapFaultMappingExceptionResolver exceptionResolver=new MyCustomSoapExceptionResolver();

	        SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
	        faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
	        faultDefinition.setFaultStringOrReason("Eccezione Default nel server da @Config class mapping");
	      
	      
	        exceptionResolver.setDefaultFault(faultDefinition);
	        exceptionResolver.setExceptionMappings(mapExceptionClassesToExceptions());
	        exceptionResolver.setOrder(-1); //override
	        return exceptionResolver;
	 }
	 
	 
	 private Properties mapExceptionClassesToExceptions(){
		 
		 Properties errorMappings = new Properties();	      
	     errorMappings.setProperty(ServiceException.class.getName(), "SERVER, Invalid request da ServiceException mapping");
	     errorMappings.setProperty(MyAnnotatedException.class.getName(), "SERVER,Invalid request da MyAnnotatedException mapping");
	     return errorMappings;
	 }
	 
}
