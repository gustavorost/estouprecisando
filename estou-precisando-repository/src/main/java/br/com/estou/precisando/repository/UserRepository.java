package br.com.estou.precisando.repository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.estou.precisando.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Serializable> {
	/**
	 * Query to disabled a user
	 * @param userId - id from the user
	 */
	@Transactional
	@Modifying
	@Query("UPDATE esp_user u SET u.status='DISABLED' WHERE u.id = :userId")
	void deleteUser(final @Param("userId") Long userId);

	/**
	 * Find user by the firstName
	 * @param name from the user
	 * @return 
	 */
	List<User> findByFirstNameOrLastNameLike(final String name,final  String lastName);

	
	/**
	 * Query to update Online or Offline from a user
	 * @param userId - id from the user
	 * @return the number of user that was disabled
	 */
	@Transactional
	@Modifying
	@Query("UPDATE esp_user u SET u.online=:statusConnection WHERE u.id = :userId")
	Integer userIsOnline(final @Param("userId") Long userId, final @Param("statusConnection") String statusConnection);

	
	@Transactional
	@Modifying
	@Query("UPDATE esp_user u SET u.status='ENABLED' WHERE u.id = :userId")
	void activateUser(final @Param("userId") Long id);

	User findByEmail(String email);

}
