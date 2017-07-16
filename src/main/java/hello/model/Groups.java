package hello.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Groups {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long groupId;

	private String name;
	
	@ManyToMany
	private Set<User> users;
	
	public Groups(){};
	
	public Groups(String name){
		this.name = name;
	}
	
	public void addUser(User user){
		this.users.add(user);
	}


	public Long getId() {
		return groupId;
	}
	

	public void setId(Long groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*
	public void setUsers(Set<User> users) {
		this.users = users;
	}
*/
}
	