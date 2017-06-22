package corso.spring.ee.demo.ws.basic.client.utils;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.FaultMessageResolver;

@Slf4j
public class SoapFaultHandlerLoggerImpl implements FaultMessageResolver{
	
	@Override
	public void resolveFault(WebServiceMessage message) throws IOException {
		LoggerUtil.logSourceAsXmlString(message.getPayloadSource());	
	}

}
