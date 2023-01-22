package com.example.lab06;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<Users, Long>{
	
}