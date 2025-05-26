package com.example.fullfood.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fullfood.entity.Product;
import com.example.fullfood.entity.admin;
import com.example.fullfood.entity.catogiry;
import com.example.fullfood.service.adminserve;
import com.example.fullfood.service.catogiryserve;
import com.example.fullfood.service.prodserv;



@Controller

public class food {
	@Autowired
	private adminserve service;
	@Autowired
	private catogiryserve serv;
	@Autowired
	private prodserv ser;
	@GetMapping("/home")
	public String home() {
		return "NewFile";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String linklogin(@RequestParam("email")String Email,@RequestParam("password")String Password,Model mo) {
		List<admin> list=service.fetchAll();
		for(admin a:list) {
			if(a.getEmail().equals(Email) && a.getPassword().equals(Password)) {
				mo.addAttribute("login", a);
				return "admin";
			}
				
		}
		return "kkkkkk";
	}
	@GetMapping("/register")
	public String addregister(Model mo) {
		mo.addAttribute("register", new admin());
		return "register";
	}
	@PostMapping("/register")
	public String takeregister(@ModelAttribute admin ad) {
		service.saveAdmin(ad);
		return "redirect:/register";
	}
	@GetMapping("/catogiry")
	public String listcato(Model mo) {
		mo.addAttribute("catogiry", serv.listcato());
		return "catogiry";
	}
	@GetMapping("/catoadd")
	public String addcato(Model mo) {
		mo.addAttribute("catoadd", new catogiry());
		return "catoadd";
	}
	@PostMapping("/catoadd")
	public String postcato(@ModelAttribute catogiry ca) {
		serv.addcato(ca);
		return "redirect:/catogiry";
	}
	@GetMapping("catogiry/edit/{id}")
	public String editcato(@PathVariable(value = "id") Integer id, Model model) {
	    Optional<catogiry> optionalCato = serv.editcato(id);
	    if (optionalCato.isPresent()) {
	        model.addAttribute("catoadd", optionalCato.get());
	        return "catoadd";
	    } else {
	        // Option 1: Redirect to a list page with error message
	        return "redirect:/catogiry/list?error=notfound";

	        // Option 2: Or show a 404 page
	        // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
	    }
	}

	@GetMapping("catogiry/delete/{id}")
	public String deletecato(@PathVariable Integer id) {
		serv.deletecato(id);
		
		return "redirect:/catogiry";
	}
	@GetMapping("/product")
	public String listpro(Model mo) {
		mo.addAttribute("product", ser.listpro());
		return "product";
	}
	@GetMapping("/prodadd")
	public String addpro(Model mo) {
		mo.addAttribute("productdto", new Product());
		mo.addAttribute("catogiry", serv.listcato());
		return "prodadd";
	}
	@PostMapping("/prodadd")
	public String fetch(@ModelAttribute Product p) {
		ser.savepro(p);
		return "redirect:/product";
	}
	@GetMapping("product/delete/{id}")
	public String deleteprod(@PathVariable Integer id) {
		ser.deleteid(id);
		
		return "redirect:/product";
	}
	@GetMapping("/product/edit/{id}")
	public String editProduct(@PathVariable Integer id, Model model) {
	    Optional<Product> product = ser.fetchid(id);
	    if (product.isPresent()) {
	        model.addAttribute("productdto", product.get());
	        model.addAttribute("catogiry", serv.listcato());
	        return "prodadd";
	    } else {
	        return "redirect:/product?error=notfound";
	    }
	}
	@PostMapping("/product/update")
	public String updateProduct(@ModelAttribute Product p) {
	    ser.savepro(p); // update if proid exists
	    return "redirect:/product";
	}
	

	
	

}
