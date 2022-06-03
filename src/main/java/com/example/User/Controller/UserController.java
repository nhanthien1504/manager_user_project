package com.example.User.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.User.Model.User;
import com.example.User.Repository.UserRepository;
import com.example.User.Service.UserServices;
import com.example.User.Service.UserServicesImps;

@Controller
public class UserController {

	@Autowired
	private UserServicesImps userService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/create")
	public void createUser(@RequestBody User user) {
		try {
			userService.CreateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// display list of User
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listUser", userRepository.findAll());
		return "index";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public ModelAndView showEditUserPage(@PathVariable(name = "id") Long id) {
		ModelAndView view = new ModelAndView("editUser");
		Optional<User> user = userService.findByUserId(id);
		view.addObject("user", user);
		return view;
	}

	@GetMapping("/showFormForCreate")
	public ModelAndView showCreateUserPage() {
		ModelAndView view = new ModelAndView("addUser");
		User user = new User();
		view.addObject("user", user);
		return view;
	}

	@PostMapping("/add")
	public String saveUserAdd(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addUser";
		}
		userService.saveUser(user);
		return "redirect:/";
	}

	@PostMapping("/edit")
	public String saveUserEdit(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "editUser";
		}
		userService.EditUser(user);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable(value = "id") long id) {

		userService.deleteUser(id);
		return "redirect:/";
	}

	@GetMapping("/info/{id}")
	public ModelAndView viewInfoUser(@PathVariable(name = "id") long id) {
		ModelAndView view = new ModelAndView("infoUser");
		Optional<User> user = userService.findByUserId(id);
		if (user.isPresent()) {
			view.addObject("listUser", user.get());
		}else {
			
		}
		return view;
		
	}

}
