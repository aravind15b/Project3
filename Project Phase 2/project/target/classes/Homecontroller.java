package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.UserDaoImpl.UserDaoImpl;
import com.model.User;
@Controller
public class Homecontroller {
@Autowired
UserDaoImpl userDaoImpl;
@RequestMapping("/index")
public String getindex()
{
	return"index";
}
@RequestMapping("/header")
public String goToheader()
{
	return"header";
}
@RequestMapping("/Register")
public String goToRegister()
{
	return"Register";
}

@RequestMapping(value="/saveregister",method=RequestMethod.POST)
	public ModelAndView saveRegister(@ModelAttribute("User")User user) {
		ModelAndView mv=new ModelAndView();
		user.setRole("Role_User");
		userDaoImpl.insertUser(user);
		mv.setViewName("index");
		return mv;
	}

}

