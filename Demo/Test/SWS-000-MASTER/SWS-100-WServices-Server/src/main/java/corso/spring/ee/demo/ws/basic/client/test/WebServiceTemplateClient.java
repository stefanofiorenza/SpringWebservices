package corso.spring.ee.demo.ws.basic.client.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import corso.spring.ee.ws.userservice.EchoUserRequest;
import corso.spring.ee.ws.userservice.EchoUserResponse;
import corso.spring.ee.ws.usertype.UserType;

public class WebServiceTemplateClient {

	

public static void main(String []a){
		
		ApplicationContext contesto = new ClassPathXmlApplicationContext("corso/spring/ee/demo/ws/basic/client/config/ws-template-example.xml");
		WebServiceTemplate webServiceTemplate =contesto.getBean("myWsTemplate",WebServiceTemplate.class);
		sendJaxbObject(webServiceTemplate);
	}	
	
    public static void sendJaxbObject(WebServiceTemplate webServiceTemplate){
    	
    	UserType user = new UserType();
    	user.setCognome("Fiorenza");
    	user.setNome("Stefano");
    	user.setEmail("stefano@email.it");
    	user.setTelefono("12453453453");
    	
    	EchoUserRequest requestPayload = new EchoUserRequest();
    	requestPayload.setUser(user);
    	EchoUserResponse response=(EchoUserResponse)webServiceTemplate.marshalSendAndReceive(requestPayload);
    	System.out.println("Ricevuto: "+response);
    	printJaxbObject(response);
		
    }
    
    public static void printJaxbObject(EchoUserResponse response){
    	
    	
    	UserType user= response.getUser();
    	String nome=user.getNome();
    	String cognome=user.getCognome();
    	String email=user.getEmail();
    	String telefono=user.getTelefono();
    	
    	System.out.println("Response: User:");
    	System.out.println("nome "+nome);
    	System.out.println("cognome "+cognome);
    	System.out.println("email "+email);
    	System.out.println("telefono "+telefono);    	
    }
}
