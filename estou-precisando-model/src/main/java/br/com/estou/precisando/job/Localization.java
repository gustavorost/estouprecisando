package br.com.estou.precisando.job;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;

import br.com.estou.precisando.user.User;

@Entity(name="esp_localization")
public class Localization {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="amplitude", nullable=false)
	private String amplitude;
	
	@Column(name="latitude", nullable=false)
	private String latitude;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;

}
