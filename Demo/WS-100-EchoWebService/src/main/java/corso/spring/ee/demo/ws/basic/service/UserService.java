package corso.spring.ee.demo.ws.basic.service;

import java.util.List;

import corso.spring.ee.demo.ws.basic.model.User;
import corso.spring.ee.demo.ws.basic.service.exceptions.ServiceException;

public interface UserService {

	public User echoUser(User utente) throws ServiceException;

	public List<User> getUsers(String criterio) throws ServiceException;
	
	public void addUser (User daAggiungere) throws ServiceException;
}
