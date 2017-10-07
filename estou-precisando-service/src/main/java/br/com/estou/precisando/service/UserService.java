package br.com.estou.precisando.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.estou.precisando.user.User;

@Service
public interface UserService {

	void deleteUser(final Long id);
	
	void activateUser(final Long id);
	
	Integer updateStatusConnection(final Long id);

	Iterable<User> findAll();

	List<User> findUsersByName(final String name);

	User createUser(User user);
	
}
