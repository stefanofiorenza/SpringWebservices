package corso.spring.ee.demo.ws.basic.interceptors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

import corso.spring.ee.demo.ws.basic.utils.LoggerUtil;

@Slf4j
public class CustomEndpointInterceptor implements EndpointInterceptor {

	@Override
	public boolean handleRequest(MessageContext messageContext, Object endpoint)
			throws Exception {
				
		log.info("Received Request Message {} for Endpoint {}", endpoint.getClass().getName(),
				LoggerUtil.getSourceAsXmlString(messageContext.getRequest().getPayloadSource()));
		
	    return true;
	}

	@Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint)
			throws Exception {
		
		log.info("Deliver Response Message {} for Endpoint {}",
				LoggerUtil.getSourceAsXmlString(messageContext.getResponse().getPayloadSource()), 
						endpoint.getClass().getName());
	    return true;
	}

	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint)
			throws Exception {
		
		log.info("Deliver Exception Message {} for Endpoint {}", 
				LoggerUtil.getSourceAsXmlString(messageContext.getResponse().getPayloadSource()),
						endpoint.getClass().getName());
	    return true;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Object endpoint,
			Exception ex) throws Exception {
		log.info("afterCompletion for Endpoint {}", endpoint.getClass().getName());
		
	}

}
