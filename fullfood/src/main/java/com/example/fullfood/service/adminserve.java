package com.example.fullfood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fullfood.entity.admin;
import com.example.fullfood.repo.adminrepo;

@Service
public class adminserve {
	@Autowired
	private adminrepo repo;
	
	public admin saveAdmin(admin ad) {
		return repo.save(ad);
	}
	public void deleteAdmin(admin ad) {
		repo.delete(ad);
	}
	public List<admin> fetchAll(){
		return repo.findAll();
	}
	public admin updatAdmin(admin ad) {
		return repo.save(ad);
	}
	

}
