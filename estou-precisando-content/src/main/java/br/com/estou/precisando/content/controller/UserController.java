package br.com.estou.precisando.content.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estou.precisando.service.UserService;
import br.com.estou.precisando.user.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<User> findAll() {
		return userService.findAll();
	}

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public Iterable<User> findByName(@PathVariable final String name) {
		return userService.findUsersByName(name);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable final Long id) {
		userService.deleteUser(id);
	}
	
	@RequestMapping(value = "/activate/{id}", method = RequestMethod.PUT)
	public void activateUser(@PathVariable final Long id) {
		userService.activateUser(id);
	}
	
	@RequestMapping(value = "/online/{id}", method = RequestMethod.PUT)
	public Integer updateStatusConnection(@PathVariable final Long id) {
		return userService.updateStatusConnection(id);
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public User createUser(@RequestBody final User user) {
		return userService.createUser(user);
	}

}
