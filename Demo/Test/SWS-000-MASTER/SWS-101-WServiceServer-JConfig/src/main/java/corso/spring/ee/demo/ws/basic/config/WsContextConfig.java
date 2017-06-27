package corso.spring.ee.demo.ws.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.soap.axiom.AxiomSoapMessageFactory;

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
}
