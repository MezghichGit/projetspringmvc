package com.sipacademy.stockmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sipacademy.stockmanager.services.UserService;
import com.sipacademy.stockmanager.entities.User;

@Controller
@RequestMapping("/admin")
public class CrudAdminController {
	
	@Autowired
	private  UserService userService;
	
	@RequestMapping("/add")
	public String addAdminForm(Model model)
	{
		model.addAttribute("user", new User());
		return "/dashboard/addAdmin.html";
	}
	
	@RequestMapping("/list")
	public String adminList()
	{
		return "/dashboard/listAdmin.html";
	}
	
	@RequestMapping("/save")
	public ModelAndView  Register(@ModelAttribute("user") User user,BindingResult bindingResult) {
	    ModelAndView modelAndView = new ModelAndView();
	    User userExists = userService.findUserByEmail(user.getEmail());
	    if (userExists != null) {
	        bindingResult
	                .rejectValue("email", "error.user",
	                        "There is already a user registered with the email provided");
	    }
	    if (bindingResult.hasErrors()) {
	        modelAndView.setViewName("/dashboard/listAdmin");
	    } else {
	        userService.saveUser(user);
	        modelAndView.addObject("successMessage", "User has been registered successfully");
	        modelAndView.addObject("user", new User());
	        modelAndView.setViewName("/dashboard/listAdmin");
	    }
	    return modelAndView;
	    }


}
