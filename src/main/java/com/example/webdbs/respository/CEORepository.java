package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.CEO;
@Repository
public interface CEORepository extends JpaRepository<CEO, Long>{

}
