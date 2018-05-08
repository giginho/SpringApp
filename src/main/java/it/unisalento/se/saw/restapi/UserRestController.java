package it.unisalento.se.saw.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.unisalento.se.saw.Iservices.IUserService;
import it.unisalento.se.saw.domain.User;
import it.unisalento.se.saw.dto.UserDTO;
import it.unisalento.se.saw.exceptions.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	IUserService userService;
	
	public UserRestController() {
		super();
	}
	
	public UserRestController(IUserService userService) {
		this.userService = userService;
	}
	
	
	
	
	@RequestMapping(value="/getAll", 
					method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@GetMapping(
				value="/getById/{id}",
				produces=MediaType.APPLICATION_JSON_VALUE
			)
	public UserDTO getById( @PathVariable("id") int id) throws UserNotFoundException {
		User user = userService.getById(id);
		UserDTO userDTO = new UserDTO();
		userDTO.setName(user.getName());
		userDTO.setSurname(user.getSurname());
		return userDTO;
	}
	
	@PostMapping(
			value="/save",
			consumes=MediaType.APPLICATION_JSON_VALUE
			)
	public User post(@RequestBody UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		return userService.save(user);
	}

}
