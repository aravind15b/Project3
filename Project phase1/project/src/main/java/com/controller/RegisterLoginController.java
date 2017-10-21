package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.UserDaoImpl.UserDaoImpl;
import com.model.User;

@Controller
public class RegisterLoginController {
@Autowired
UserDaoImpl userDaoImpl;

@RequestMapping("/header")
public String gotoheader() {
	return"header";
}


@RequestMapping(value= "/saveRegister")
public String gotosaveRegister( Model m) { 
	m.addAttribute("retrive",userDaoImpl.retrive());
	return "saveRegister";
}
@RequestMapping("/Register")
public String gotoRegister(@ModelAttribute("Userobj")User user) {
	return"Register";
}


@RequestMapping(value="/saveRegister",method=RequestMethod.POST)
public String saveRegister(User user) {
	ModelAndView mv=new ModelAndView();
	user.setRole("Role_User");
	userDaoImpl.insertUser(user);
	//mv.setViewName("index");
	return "redirect:/saveRegister";
}

@RequestMapping("/getUserList")
public ModelAndView getAllUsers()
{
	 List<User>ll=userDaoImpl.retrive();
	 ModelAndView ss=new ModelAndView("saveRegister","retrive",ll);
	 return ss;
}

@RequestMapping("/edit")
public String editUser(@RequestParam("eid") String emailid, Model m) {
	User user=userDaoImpl.getUser(emailid);
	m.addAttribute("user",user);
	m.addAttribute("userupdate",new User());
	return "edituser";

}
@RequestMapping(value="/updateUser",method=RequestMethod.POST)
public String Updateuser(User user,Model m) {
	userDaoImpl.updateUser(user);
	m.addAttribute("retrive",this.userDaoImpl.retrive());
	return"saveRegister";
}
@RequestMapping("/remove")
public String removeUser(@RequestParam("eid") String emailid,Model m)
{
	m.addAttribute("userupdate1",this.userDaoImpl.getUser(emailid));
	m.addAttribute("user", new User());
	return "remove";
}
@RequestMapping(value="/updateUser1",method=RequestMethod.POST)
public String Delete(String emailid ,Model m) {
	userDaoImpl.removeUser(emailid);
	m.addAttribute("retrive",this.userDaoImpl.retrive());
	return "saveRegister";
}
}
