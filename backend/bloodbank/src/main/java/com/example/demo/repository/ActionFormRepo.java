package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.module.ActionForm;

public interface ActionFormRepo extends JpaRepository<ActionForm, Integer> {
	

}
