package com.example.fullfood.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fullfood.entity.catogiry;
@Repository
public interface catogiryrepo extends JpaRepository<catogiry, Integer> {

	

}
