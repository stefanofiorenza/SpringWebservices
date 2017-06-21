package corso.spring.ee.demo.ws.basic.endpoints;

import org.springframework.beans.factory.annotation.Autowired;

import corso.spring.ee.demo.ws.basic.service.UserService;

public class UserServiceEndpoint {
	    
    @Autowired
    private UserService userService;   

}
