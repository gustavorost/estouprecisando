package br.com.estou.precisando.service.provider;

import static br.com.estou.precisando.util.validator.ValidatorDate.validateAge;
import static br.com.estou.precisando.util.validator.ValidatorUtil.notNullParameter;
import static br.com.estou.precisando.util.validator.ValidatorUtil.validateEmail;
import static br.com.estou.precisando.util.validator.ValidatorCpf.validateCpf;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estou.precisando.repository.UserRepository;
import br.com.estou.precisando.service.UserService;
import br.com.estou.precisando.user.Status;
import br.com.estou.precisando.user.User;

@Service
public class UserServiceImpl implements UserService {

	private static final String ONLINE = "ONLINE";
	private static final String OFFLINE = "OFFLINE";
	private static final String ADDRESS_FIELD = "Address";
	private static final String FIRST_NAME_FIELD = "FirstName";
	private static final String LAST_NAME_FIELD = "LastName";
	private static final String PASSWORD = "Password";
	private static final String CPF = "CPF";
	private static final String DATE_OF_BIRTH_FIELD = "DateOfBirth";

	@Autowired
	UserRepository userRepository;

	@Transactional
	public void deleteUser(final Long id) {
		userRepository.deleteUser(id);
	}

	@Transactional
	public void activateUser(final Long id) {
		userRepository.activateUser(id);
	}

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findUsersByName(final String name) {
		return userRepository.findByFirstNameOrLastNameLike(name, name);
	}

	@Transactional
	public Integer updateStatusConnection(final Long id) {

		String statusConnection;
		User user = userRepository.findOne(id);

		if (user.getOnline() != null && user.getStatus().equals(Status.ENABLED) && user.getOnline().equals(OFFLINE)) {
			statusConnection = ONLINE;
		} else {
			statusConnection = OFFLINE;
		}

		return userRepository.userIsOnline(id, statusConnection);
	}

	@Transactional
	public User createUser(final User user) {
		validateUser(user);
		User findUser = userRepository.findByEmail(user.getEmail());
		
		if(findUser!=null) {
			throw new IllegalArgumentException("validate.user.exist");
		}
		
		return userRepository.save(user);
	}

	private void validateUser(User user) {
		notNullParameter(user);
		notNullParameter(user.getCpf(), CPF);
		notNullParameter(user.getPassword(), PASSWORD);
		notNullParameter(user.getAddress(), ADDRESS_FIELD);
		notNullParameter(user.getLastName(), LAST_NAME_FIELD);
		notNullParameter(user.getFirstName(), FIRST_NAME_FIELD);
		notNullParameter(user.getDateOfBirth(), DATE_OF_BIRTH_FIELD);
		validateAge(user);
		validateEmail(user.getEmail());
		validateCpf(user.getCpf());
	}
	

}
