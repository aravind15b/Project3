package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.UserDaoImpl.CategoryDaoImpl;
import com.UserDaoImpl.ProductDaoImpl;
import com.model.Category;
import com.model.Product;

@Controller
public class ProductController {
	@Autowired 
	CategoryDaoImpl categoryDaoImpl;
	@Autowired
	ProductDaoImpl productDaoImpl;
	@RequestMapping("/ProductHome")
	public String gotoProductHome(Product product,Model m) {
		m.addAttribute("proddetail",new Product());
		m.addAttribute("proddetail",productDaoImpl.retrive());
		return "ProductHome";
	}
	@RequestMapping("/Product")
	public String gotoProduct(Product product, Model m) {
		m.addAttribute("product",new Product());
		m.addAttribute("catdetail",this.getCatList());
		m.addAttribute("proddetail",productDaoImpl.retrive());
		return "Product";
}
	@RequestMapping(value="/Product/add",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,Model m) {
		if(product.getProid()==0)
		productDaoImpl.insertProduct(product);
		else
		productDaoImpl.updateProduct(product);
		return "redirect:/Product";
}
	@RequestMapping("/editProduct/{proid}")
	public String editProduct(@PathVariable("proid") int proid,Model m,Product product) {
	m.addAttribute("product",productDaoImpl.getProduct(proid));
	return "Product";
	}

	@RequestMapping("deleteProduct/{proid}")
	public String deleteCategory(@PathVariable("proid") int proid,Model m,Product product) {
	m.addAttribute("product",productDaoImpl.getProduct(proid));
	productDaoImpl.removeProduct(product);
	m.addAttribute("proddetail",this.productDaoImpl.retrive());
	return "redirect:/Product";
	}
	public LinkedHashMap<Integer, String> getCatList() {
		List<Category> list = categoryDaoImpl.retrive();

		LinkedHashMap<Integer, String> catlist = new LinkedHashMap<Integer, String>();

		for (Category cat : list) {
			catlist.put(cat.getCatid(),cat.getCatname());
		}
		
		return catlist;
	}
	@RequestMapping(value = "/Product/Add", method = RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product, Model m,
			@RequestParam("pimage") MultipartFile filedet,BindingResult result)

	{
		System.out.println("---Product Inserted---");
		productDaoImpl.insertProduct(product);
		
		System.out.println("Images storing started");
		String path="G:\\eclipse\\New folder\\project\\src\\main\\webapp\\resources\\images";
		System.out.println("images stored");
		String fileinfo=path+product.getProid()+".jpg";
		File f=new File(fileinfo);
		if(!filedet.isEmpty())
		{
			try
			{
				byte buff[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buff);
				bs.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised");
			}
		}
			else 
				
				{
					System.out.println("File uploading problem");
				}
		System.out.println("images stored");
		
		
		m.addAttribute("proddetail",productDaoImpl.retrive());
		
		return "ProductHome";
		
}





}