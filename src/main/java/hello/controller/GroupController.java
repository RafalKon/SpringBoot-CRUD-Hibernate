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
//@RequestMapping(path="/group")
public class GroupController {

	@RequestMapping(path="/group")
	public String index(Model model){
		List<Groups> groups = (List<Groups>) groupRepository.findAll();
		model.addAttribute("groups",groups);
		return "group";
	}
	
	
	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	UserRepository userRepository;
	

	
	@GetMapping(value="/delete/{id}")
	public String deleteUserById(@PathVariable("id") Long groupId){
		groupRepository.delete(groupId);
			
		return "redirect:/group";
	}
	
	

	@GetMapping(path="/addtouser/{userId}/{groupId}") 
	public @ResponseBody String addGroupToUser(@PathVariable("userId")Long userId, @PathVariable("groupId")Long groupId) {
		
		User user = userRepository.findOne(userId);
		Groups group = groupRepository.findOne(groupId);

		group.addUser(user);
		user.addGroup(group);
		
		userRepository.save(user);
		return "Group added to User";
	}
	
    @PostMapping(value = "/savegroup")
    public String save(Groups group){
        groupRepository.save(group);
        return "redirect:/group";
    }
	
    @RequestMapping(value="/editgroup/{id}")
    public String editGroup(@PathVariable("id") Long groupId, Model model){
    	model.addAttribute("groups", groupRepository.findOne(groupId));
    	return "redirect:/group";
    }
	
}