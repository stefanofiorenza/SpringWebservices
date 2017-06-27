package corso.spring.ee.demo.ws.basic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "corso.spring.ee.demo.ws.basic.service" })
public class ServiceContext {

}
