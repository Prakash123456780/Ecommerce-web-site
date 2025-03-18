package com.example.fullfood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fullfood.entity.catogiry;
import com.example.fullfood.repo.catogiryrepo;

@Service
public class catogiryserve {
	@Autowired
	private catogiryrepo catrepo;
	
	public catogiry addcato(catogiry ca) {
		return catrepo.save(ca);
	}
	
	public void deletecato(Integer id) {
		catrepo.deleteById(id);
	}
	public List<catogiry> listcato() {
		return catrepo.findAll();
	}
	public Optional<catogiry> editcato(Integer id) {
		return catrepo.findById(id);
	}

}
