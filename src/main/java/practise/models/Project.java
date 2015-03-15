package practise.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author practise
 */
@Entity
@Table(name = "projects")
public class Project {

  // ==============
  // PRIVATE FIELDS
  // ==============
  
  // An autogenerated id (unique for each user in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long id;
  
  // The user email
  @Column
  public String client;

  @Column
  public String location;
  
  // The user name

  @Column
  public String projectname;

  // ==============
  // PUBLIC METHODS
  // ==============
  
  public Project() { }

  public Project(long projectid) { 
    this.id = projectid;
  }
  
  public Project(String projectname, String client, String location) {
	this.projectname = projectname;
    this.client = client;
    this.location = location;
  }

public long getProjectid() {
	return id;
}

public void setProjectid(long projectid) {
	this.id = projectid;
}

public String getClient() {
	return client;
}

public void setClient(String client) {
	this.client = client;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getProjectname() {
	return projectname;
}

public void setProjectname(String projectname) {
	this.projectname = projectname;
}

  // Getter and setter methods

} // class User