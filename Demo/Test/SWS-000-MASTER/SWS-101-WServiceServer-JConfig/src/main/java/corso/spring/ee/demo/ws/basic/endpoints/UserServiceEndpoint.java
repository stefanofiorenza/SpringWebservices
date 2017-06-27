package corso.spring.ee.demo.ws.basic.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import corso.spring.ee.demo.ws.basic.model.User;
import corso.spring.ee.demo.ws.basic.service.UserService;
import corso.spring.ee.demo.ws.basic.service.exceptions.ServiceException;
import corso.spring.ee.ws.userservice.EchoUserRequest;
import corso.spring.ee.ws.userservice.EchoUserResponse;
import corso.spring.ee.ws.usertype.UserType;


@Endpoint
public class UserServiceEndpoint {

	
	public static final String USER_REQUEST_LOCAL_NAME = "echoUserRequest";
	public static final String USER_RESPONSE_LOCAL_NAME = "echoUserResponse";
	public static final String USER_NAMESPACE_URI = "http://ee.spring.corso/ws/UserService";
     
    @Autowired
    private UserService userService;

	
    @PayloadRoot(localPart = USER_REQUEST_LOCAL_NAME, namespace = USER_NAMESPACE_URI)
	@ResponsePayload
	public EchoUserResponse echoUser(@RequestPayload EchoUserRequest request) throws ServiceException{
    	
    	UserType userXml = request.getUser();			
		User user = xml2Bean(userXml);
		 	
		User userServiceOut=null;
		userServiceOut = userService.echoUser(user);		 		
		UserType userOutput =bean2Xml(userServiceOut);
				 
		EchoUserResponse response = wrapInResponse(userXml);
		return response;
    }


	private EchoUserResponse wrapInResponse(UserType userXml) {
		EchoUserResponse response = new EchoUserResponse();
		response.setUser(userXml);
		return response;
	}


	private UserType bean2Xml(User userServiceOut) {
		UserType userOutput = new UserType();
		userOutput.setNome(userServiceOut.getNome());
		userOutput.setCognome(userServiceOut.getCognome());
		userOutput.setEmail(userServiceOut.getEmail());
		userOutput.setTelefono(userServiceOut.getTelefono());
		return userOutput;
	}


	private User xml2Bean(UserType userXml) {
		User user =new User();
		 user.setNome(userXml.getNome());
		 user.setCognome(userXml.getCognome());
		 user.setEmail(userXml.getEmail());
		 user.setTelefono(userXml.getTelefono());
		return user;
	}

    
    
}
