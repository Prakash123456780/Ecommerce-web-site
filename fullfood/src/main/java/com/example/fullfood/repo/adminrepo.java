package com.example.fullfood.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fullfood.entity.admin;
@Repository
public interface adminrepo extends JpaRepository<admin, Integer> {

}
