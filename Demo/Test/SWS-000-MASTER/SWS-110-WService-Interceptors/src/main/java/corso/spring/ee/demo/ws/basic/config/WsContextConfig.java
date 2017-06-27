package corso.spring.ee.demo.ws.basic.config;

import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.axiom.AxiomSoapMessageFactory;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadRootSmartSoapEndpointInterceptor;

import corso.spring.ee.demo.ws.basic.endpoints.UserServiceEndpoint;
import corso.spring.ee.demo.ws.basic.interceptors.CustomEndpointInterceptor;
import corso.spring.ee.demo.ws.basic.interceptors.GlobalEndpointInterceptor;
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
public class WsContextConfig extends WsConfigurerAdapter  {

	
	 @Override
	    public void addInterceptors(List<EndpointInterceptor> interceptors) {

	        // register global interceptor
	        interceptors.add(new GlobalEndpointInterceptor());

	        // register endpoint specific interceptor
	        interceptors.add(new PayloadRootSmartSoapEndpointInterceptor(
	                new CustomEndpointInterceptor(),
	                UserServiceEndpoint.USER_NAMESPACE_URI,
	                UserServiceEndpoint.USER_REQUEST_LOCAL_NAME));
	    }
	 
	 @Bean
	 public AxiomSoapMessageFactory messageFactory() {
	    return new AxiomSoapMessageFactory();
	 }
	 
	 
	 @Bean
	 public SoapFaultMappingExceptionResolver exceptionResolver(){
		 
		 	SoapFaultMappingExceptionResolver exceptionResolver=new SoapFaultMappingExceptionResolver();

	        SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
	        faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
	        faultDefinition.setFaultStringOrReason("Eccezione Default nel server da annotation");
	      
	        Properties errorMappings = new Properties();	      
	        errorMappings.setProperty(ServiceException.class.getName(), "CLIENT,Invalid request da annotation");
	        
	        exceptionResolver.setDefaultFault(faultDefinition);
	        exceptionResolver.setExceptionMappings(errorMappings);
	        exceptionResolver.setOrder(-1);
	        return exceptionResolver;
	 }
	 
	 
	 
}
