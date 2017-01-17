package corso.spring.ee.demo.ws.basic.client.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.XmlMappingException;
import org.springframework.ws.client.core.WebServiceTemplate;

import corso.spring.ee.ws.userservice.EchoUserRequest;
import corso.spring.ee.ws.userservice.EchoUserResponse;
import corso.spring.ee.ws.usertype.UserType;


public class WebServiceTemplateClient {

	public static final String PATH_XML_FILE="C:/Temp/SEE/SWS/request.xml";
	private static WebServiceTemplate webServiceTemplate;

public static void main(String []a) throws IOException{
		
		ApplicationContext contesto = new ClassPathXmlApplicationContext("ws-template-example.xml");
		webServiceTemplate=contesto.getBean("myWsTemplate",WebServiceTemplate.class);
		sendJaxbObject(webServiceTemplate);
	}	
	
    public static void sendJaxbObject(WebServiceTemplate webServiceTemplate) throws IOException{
    	
    	UserType user = new UserType();
    	user.setCognome("Fiorenza");
    	user.setNome("Stefano");
    	user.setEmail("stefano@email.it");
    	user.setTelefono("12453453453");
    	
    	EchoUserRequest requestPayload = new EchoUserRequest();
    	requestPayload.setUser(user);
    	printPayloadAsXml(requestPayload);
    	EchoUserResponse response=(EchoUserResponse)webServiceTemplate.marshalSendAndReceive(requestPayload);
    	printPayloadAsXml(response);
    	printPayloadAsJaxbObject(response);
		
    }
    
    public static void printPayloadAsXml(Object objPayload){
    	StringWriter out = new StringWriter();
		StreamResult result = new StreamResult(out);
		try {
			webServiceTemplate.getMarshaller().marshal(objPayload, result);
			System.out.println(out.toString());
			PrintWriter writer = new PrintWriter(PATH_XML_FILE);
			writer.print(out.toString());
			writer.close();  
		
		} catch (XmlMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}      	
    }
 


    public static void printPayloadAsJaxbObject(EchoUserResponse response){
    	
    	
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
