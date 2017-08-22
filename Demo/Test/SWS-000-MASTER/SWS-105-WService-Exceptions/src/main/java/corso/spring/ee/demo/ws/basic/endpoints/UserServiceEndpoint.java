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
    	    	
    	throw new ServiceException("No Annotations on ServiceException occurred");
    	//throw new MyAnnotatedException("Annotated Exception occurred");

    }



    
    
}
