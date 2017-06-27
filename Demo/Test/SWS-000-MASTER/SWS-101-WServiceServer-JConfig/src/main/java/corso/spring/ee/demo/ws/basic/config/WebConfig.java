package corso.spring.ee.demo.ws.basic.config;

import org.springframework.ws.transport.http.support.AbstractAnnotationConfigMessageDispatcherServletInitializer;


public class WebConfig extends AbstractAnnotationConfigMessageDispatcherServletInitializer{

	/**
	 * Gia configurato l'equivalente del web.xml ereditando da AbstractAnnotationConfigMessageDispatcherServletInitializer
	 * 
	 * E' possibile customizzare i mappings e la generazione dinamica di wsdl
	 */
	

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ServiceContext.class };		
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		
		return new Class[] { WsContextConfig.class };
		
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/echoUserService/*" };
	}
	 	 
	
	
}
