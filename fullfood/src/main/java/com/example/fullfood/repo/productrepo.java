package com.example.fullfood.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fullfood.entity.Product;

public interface productrepo extends JpaRepository<Product, Integer> {

	



	List<Product> findAllByCatogiry_id(int id);

}
