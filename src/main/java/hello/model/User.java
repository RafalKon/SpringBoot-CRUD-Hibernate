package hello.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity 
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;

	private String login;

	private String password;

	private String firstName;

	private String lastName;

	private Date birthday;
	
	@ManyToMany(mappedBy = "users")
	private Set<Groups> groups;
	

	public User(){};
	
	public User(String login, String password, String firstName, String lastName, Date birthday // Set<Group> groups
	) {
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	//	this.groups = groups;
	}

	public void addGroup(Groups group){
		this.groups.add(group);
	}

	public Long getId() {
		return userId;
	}
	
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



/*	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
*/	
	
    
    
}

