package corso.spring.ee.demo.ws.basic.interceptors;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalEndpointInterceptor implements EndpointInterceptor {

   
    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        log.info("Global Request Handling");
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
    	log.info("Global Response Handling");
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
    	log.info("Global Exception Handling");
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
    	log.info("Execute Code After Completion");
    }
}