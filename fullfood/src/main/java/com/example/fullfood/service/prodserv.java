package com.example.fullfood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fullfood.entity.Product;
import com.example.fullfood.repo.productrepo;

@Service
public class prodserv {
	@Autowired
	private productrepo prorepo;
	
	public void savepro(Product p) {
		prorepo.save(p);
	}
	public List<Product> listpro() {
		return prorepo.findAll();
	}

	public void deleteid(int proid) {
		 prorepo.deleteById(proid);
	}
	public Optional<Product> fetchid(int proid) {
		return prorepo.findById(proid);
	}
	public List<Product> procatid(int id) {
		return prorepo.findAllByCatogiry_id(id);
	}
	 public Product getById(int proid) {
	        return prorepo.findById(proid).orElse(null);
    }

}
