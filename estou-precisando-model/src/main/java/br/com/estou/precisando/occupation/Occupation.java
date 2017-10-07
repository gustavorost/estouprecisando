package br.com.estou.precisando.occupation;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.estou.precisando.job.Job;
import br.com.estou.precisando.user.Status;
import br.com.estou.precisando.user.User;

@Entity(name="esp_occupation")
public class Occupation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	private List<User> user;
	
	@Column(name="title", nullable=false)
	private String name;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="create_date", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdDate;
	
	@Column(name="update_date", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updateDate;
	
	@OneToOne
	private User userUpdate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", length=50, nullable=false)	
	private Status status;
	

}
