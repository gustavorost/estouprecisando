package br.com.estou.precisando.job;

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

import br.com.estou.precisando.occupation.Occupation;
import br.com.estou.precisando.user.Status;
import br.com.estou.precisando.user.User;

@Entity(name = "esp_job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	private List<Occupation> occupation;

	@ManyToMany
	private List<User> userProfessional;
	
	@OneToOne
	private User userRequest;
	
	@Column(name="create_date", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdDate;
	
	@Column(name="update_date", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updateDate;
	
	@Column(name="schedule_date", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar scheduleDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 50, nullable = false)
	private Status status;
	
	@Column(name="distance_to_search", nullable=false)
	private Integer distanceToSearch;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@OneToOne
	private Localization localization;
	
	@Column(name="quantity")
	private Integer quantity;

}
