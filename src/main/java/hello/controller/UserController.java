package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Groups;
import hello.model.User;
import hello.repository.GroupRepository;
import hello.repository.UserRepository;

@Controller    
//@RequestMapping(path="/user")
public class UserController {
	
	@RequestMapping(path="/user")
	public String index(Model model){
		List<User> users = (List<User>) userRepository.findAll();
		model.addAttribute("users", users);
		return "user";
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	GroupRepository groupRepository;
	
	

	@GetMapping(value="/deleteuser/{id}")
	public String deleteUserById(@PathVariable("id") Long userId){
		userRepository.delete(userId);
			
		return "redirect:/user";
	}
	


	
	@GetMapping(value="/user/addtogroup/{userId}/{groupId}") 
	public @ResponseBody String addUserToGroup (@PathVariable("userId")Long userId, @PathVariable("groupId")Long groupId, Model model
			) {
    	model.addAttribute("user", userRepository.findOne(userId));
    	model.addAttribute("groups", groupRepository.findOne(groupId));

		User user = userRepository.findOne(userId);
		Groups group = groupRepository.findOne(groupId);

		group.addUser(user);
		user.addGroup(group);
		
		userRepository.save(user);
		return "redirect:/user";
	}
	
    @PostMapping(value = "/saveuser")
    public String saveUser(User user){
        userRepository.save(user);
        return "redirect:/user";
    }
    
    @RequestMapping(value="/edituser/{id}")
    public String editUser(@PathVariable("id") Long userId, Model model){
    	model.addAttribute("user", userRepository.findOne(userId));
    	return "redirect:/user";
    }
    
	
}
