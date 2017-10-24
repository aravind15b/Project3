package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.UserDaoImpl.CategoryDaoImpl;
import com.UserDaoImpl.SupplierDaoImpl;
import com.model.Category;
import com.model.Supplier;
@Controller
public class SupplierController {
		@Autowired 
		SupplierDaoImpl supplierDaoImpl;

		@RequestMapping("/Supplier")
		public String gotoCategory(Supplier supplier, Model m) {
			m.addAttribute("supplier",new Supplier ());
			m.addAttribute("supdetail",supplierDaoImpl.retrive());
			return "Supplier";
		}
		@RequestMapping(value="/Supplier/add",method=RequestMethod.POST)
		public String addeditCategory(@ModelAttribute("supplier")Supplier supplier,Model m) {
			if(supplier.getSupid()==0)
			supplierDaoImpl.insertSupplier(supplier);
			else
			supplierDaoImpl.updateSupplier(supplier);
			return "redirect:/Supplier";
		}	
		@RequestMapping("/editSupplier/{supid}")
		public String editCategory(@PathVariable("supid") int supid,Model m,Supplier supplier) {
		m.addAttribute("supplier",supplierDaoImpl.getSupplier(supid));
		return "Supplier";
		}

		@RequestMapping("deleteSupplier/{supid}")
		public String deleteCategory(@PathVariable("supid") int supid,Model m,Supplier supplier) {
		m.addAttribute("supplier",supplierDaoImpl.getSupplier(supid));
		supplierDaoImpl.removeSupplier(supplier);
		m.addAttribute("supdetail",this.supplierDaoImpl.retrive());
		return "redirect:/Supplier";
		}



		}


