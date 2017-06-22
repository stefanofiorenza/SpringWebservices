package corso.spring.ee.demo.ws.basic.client.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import corso.spring.ee.demo.ws.basic.client.utils.LoggerUtil;
import corso.spring.ee.ws.userservice.EchoUserRequest;
import corso.spring.ee.ws.userservice.EchoUserResponse;
import corso.spring.ee.ws.usertype.UserType;


@Slf4j
public class WebServiceTemplateClient {

	public static final String PATH_XML_FILE="C:/Temp/SEE/SWS/request.xml";
	private static WebServiceTemplate webServiceTemplate;

	public static void main(String []a) throws IOException{
		
		ApplicationContext contesto = new ClassPathXmlApplicationContext("configs/ws-template-example.xml");
    	webServiceTemplate=contesto.getBean("myWsTemplate",WebServiceTemplate.class);
    	testMarshalSendAndReceive();
	}	
	
    private static void testMarshalSendAndReceive() throws IOException{
    		
    	EchoUserRequest requestPayload=createMockUserRequest();
    	logPayloadAsXml(requestPayload);  
    	
    	EchoUserResponse response=(EchoUserResponse)webServiceTemplate.marshalSendAndReceive(requestPayload);
    	logResponsePayload(response);
    }
    
    
	private static void logPayloadAsXml(Object objPayload){		
		
    	StringWriter out = new StringWriter();
		StreamResult result = new StreamResult(out);
		try {
			webServiceTemplate.getMarshaller().marshal(objPayload, result);
			log.info(out.toString());
			PrintWriter writer = new PrintWriter(PATH_XML_FILE);
			writer.print(out.toString());
			writer.close();  
		
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}       	
    }
	
    
    
    private static void logResponsePayload(EchoUserResponse response){
    	if(response!=null && response.getUser()!=null){
    		logPayloadAsXml(response);
    		log.info("\n***************Response.User*********************\n"+response.getUser().toString());  
    	}else{
    		log.info("ECCEZIONE: Response was null!");
    	}	
    }
 
    private static EchoUserRequest createMockUserRequest(){
    	UserType user = new UserType();
    	user.setCognome("Fiorenza");
    	user.setNome("Stefano");
    	user.setEmail("stefano@email.it");
    	user.setTelefono("12453453453");    	
    	
    	EchoUserRequest requestPayload = new EchoUserRequest();
    	requestPayload.setUser(user);    	
    	return requestPayload;
    }

  
}
