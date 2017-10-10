package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.UserDaoImpl.CategoryDaoImpl;
import com.model.Category;

@Controller
public class CategoryController {
@Autowired 
CategoryDaoImpl categoryDaoImpl;

@RequestMapping("/Category")
public String gotoCategory(Category category, Model m) {
	m.addAttribute("category",new Category());
	m.addAttribute("catdetail",categoryDaoImpl.retrive());
	return "Category";
}
@RequestMapping(value="/Category/add",method=RequestMethod.POST)
public String addeditCategory(@ModelAttribute("category")Category category,Model m) {
	if(category.getCatid()==0)
	categoryDaoImpl.insertCategory(category);
	else
	categoryDaoImpl.updateCategory(category);
	return "redirect:/Category";
}	
@RequestMapping("/editCategory/{catid}")
public String editCategory(@PathVariable("catid") int catid,Model m,Category category) {
m.addAttribute("category",categoryDaoImpl.getCategory(catid));
return "Category";
}

@RequestMapping("deleteCategory/{catid}")
public String deleteCategory(@PathVariable("catid") int catid,Model m,Category category) {
m.addAttribute("category",categoryDaoImpl.getCategory(catid));
categoryDaoImpl.removeCategory(category);
m.addAttribute("catdetail",this.categoryDaoImpl.retrive());
return "redirect:/Category";
}



}

