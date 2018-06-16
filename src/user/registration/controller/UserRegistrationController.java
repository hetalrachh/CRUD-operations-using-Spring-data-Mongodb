package user.registration.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import user.registration.model.Users;
import user.registration.service.UsersServiceImpl;

@Controller
public class UserRegistrationController {

	@Autowired
	private UsersServiceImpl userService;

	@RequestMapping(value = "/userregistration.html", method = RequestMethod.GET)
	public ModelAndView userRegistration() {

		ModelAndView model = new ModelAndView("user-registration");
		return model;

	}

	//adding a new user
	@RequestMapping(value = "/registereddetails.html", method = RequestMethod.POST)
	public ModelAndView registeredDetails(@ModelAttribute("userDetails") Users user) {

		ModelAndView model = new ModelAndView("registered-details");

		// adding a new user to the database
		userService.addUser(user);

		return model;

	}

	//view a registered user details
	@RequestMapping(value = "/view-registered-details/{id}")
	public ModelAndView viewRegisteredDetails(@PathVariable(value = "id") String id) {

		ModelAndView model = new ModelAndView("view-registered-details");

		// find registered details
		Users user = userService.find(id);
		model.addObject("registeredDetails", user);

		return model;

	}

	//view all registered details
	@RequestMapping(value = "/view-all-registered-details")
	public ModelAndView viewAllRegisteredDetails(Map<String, Object> map) {

		// find all registered users
		List<Users> allUsers = userService.findAll();

		map.put("allDetails", allUsers);

		return new ModelAndView("view-all-registered-details", map);
	}

	//deleting a user
	@RequestMapping(value = "delete-a-user/{id}")
	public ModelAndView deleteUser(@PathVariable(value = "id") String id, Map<String, Object> map) {
		// find the user by id and then remove the user
		Users user = userService.find(id);
		userService.delete(user);

		// find all users
		List<Users> allUsers = userService.findAll();

		map.put("allDetails", allUsers);

		return new ModelAndView("view-all-registered-details", map);
	}

	//edit user details
	@RequestMapping(value = "/saveedit.html", method = RequestMethod.POST)
	public ModelAndView saveEdit(@ModelAttribute("saveDetails") Users user) {

		ModelAndView model = new ModelAndView("view-saved-details");
		userService.edit(user);

		Users updatedDetails = userService.find(user.getId());
		model.addObject("updatedDetails", updatedDetails);
		return model;
	}

}
