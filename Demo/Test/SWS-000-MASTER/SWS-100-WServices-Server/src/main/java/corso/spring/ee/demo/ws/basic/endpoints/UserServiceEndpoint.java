package corso.spring.ee.demo.ws.basic.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import corso.spring.ee.demo.ws.basic.service.UserService;
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

}
