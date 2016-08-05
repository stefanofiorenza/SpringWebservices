package corso.spring.ee.demo.ws.basic.service;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Service;

import corso.spring.ee.demo.ws.basic.model.User;
import corso.spring.ee.demo.ws.basic.service.exceptions.ServiceException;


@Service
public class UserServiceImpl implements UserService {

	Vector<User> utenti = new Vector<User>();
	
	
	public User echoUser(User utente) throws ServiceException {		
		return utente;
	}

	
	public List<User> getUsers(String criterio) throws ServiceException {
		return utenti;
	}


	public void addUser(User daAggiungere) throws ServiceException {
		utenti.add(daAggiungere);
		
	}

}
