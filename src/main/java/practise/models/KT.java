package practise.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "KT")
public class KT {
	
	  // An autogenerated id (unique for each user in the db)

	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  public long id;
	  
	  
	  // The user email

	  @OneToOne
	  @JoinColumn(name="trainee", nullable=false)
	  public User trainee;
	  
	  @OneToOne
	  @JoinColumn(name="trainer", nullable=false)
	  public User trainer;
	  
	  // The user name
	  @Column
	  public Date startDate;
	  
	  @Column
	  public Date endDate;

	  @OneToOne
	  @JoinColumn(name="project", nullable=false)
	  public Project project;
	  
	  @Column
	  public String topic;

	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public User getTrainee() {
		return trainee;
	}


	public void setTrainee(User trainee) {
		this.trainee = trainee;
	}
	

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	  
}
