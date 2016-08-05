package corso.spring.ee.demo.ws.basic.endpoints;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import corso.spring.ee.demo.ws.basic.model.User;
import corso.spring.ee.demo.ws.basic.service.UserService;
import corso.spring.ee.demo.ws.basic.service.exceptions.ServiceException;
import corso.spring.ee.demo.ws.basic.xmltypes.EchoUserRequest;
import corso.spring.ee.demo.ws.basic.xmltypes.EchoUserResponse;
import corso.spring.ee.demo.ws.basic.xmltypes.UserType;


@Endpoint
public class UserServiceEndpoint {

	
    public static final String USER_REQUEST_LOCAL_NAME = "echoUserRequest";
    public static final String USER_RESPONSE_LOCAL_NAME = "echoUserResponse";
    public static final String USER_NAMESPACE_URI = "http://corso.spring.ee/ws/UserService";
    
    private static final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    
    @Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	 @PayloadRoot(localPart = USER_REQUEST_LOCAL_NAME, namespace = USER_NAMESPACE_URI)
	 @ResponsePayload
	 public EchoUserResponse echoUser(@RequestPayload EchoUserRequest request){
		 
		 UserType userXml = request.getUser();
		 
		 /*
		 //conversione in bean per servizi
		 User user =new User();
		 user.setNome(userXml.getNome());
		 user.setCognome(userXml.getCognome());
		 user.setEmail(userXml.getEmail());
		 user.setTelefono(userXml.getTelefono());
		 	
		 User userServiceOut= null;
		 try {
			 userServiceOut= userService.echoUser(user);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 //conversione in bean per trasporto xml
		UserType userOutput = new UserType();
		userOutput.setNome(userServiceOut.getNome());
		userOutput.setCognome(userServiceOut.getCognome());
		userOutput.setEmail(userServiceOut.getEmail());
		userOutput.setTelefono(userServiceOut.getTelefono());
		
		*/
		 
		EchoUserResponse response = new EchoUserResponse();
		response.setUser(userXml);
		return response;
		 
	}
	 
	 /*
	 
	 @PayloadRoot(localPart = ECHO_REQUEST_LOCAL_NAME, namespace = ECHO_NAMESPACE_URI)
	 @ResponsePayload
	 public Element echoRequest (@RequestPayload Element requestElement) throws ParserConfigurationException{
		 
		 	Assert.isTrue(ECHO_NAMESPACE_URI.equals(requestElement.getNamespaceURI()), "Invalid namespace");
	        Assert.isTrue(ECHO_REQUEST_LOCAL_NAME.equals(requestElement.getLocalName()), "Invalid local name");

	        NodeList children = requestElement.getChildNodes();
	        Text requestText = null;
	        for (int i = 0; i < children.getLength(); i++) {
	            if (children.item(i).getNodeType() == Node.TEXT_NODE) {
	                requestText = (Text) children.item(i);
	                break;
	            }
	        }
	        if (requestText == null) {
	            throw new IllegalArgumentException("Could not find request text node");
	        }

	        String echo = requestText.getNodeValue();

	        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	        Document document = documentBuilder.newDocument();
	        Element responseElement = document.createElementNS(ECHO_NAMESPACE_URI, ECHO_RESPONSE_LOCAL_NAME);
	        Text responseText = document.createTextNode(echo);
	        System.out.println("[echoRequest]prima: "+responseElement.getChildNodes().getLength());
		    responseElement.appendChild(responseText);
	        System.out.println("[echoRequest]dopo: "+responseElement.getFirstChild().getNodeValue());
			   
	        System.out.println("[echoRequest]: "+responseElement);
	        return responseElement;

	 }
	 */
}
