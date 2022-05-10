package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.Recruit;
@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Long>{

}
