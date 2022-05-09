package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	@Query("SELECT e FROM Admin e where e.username = ?1 and e.password = ?2")
	Admin findByUsernameAndPassword(String username, String password);
}
