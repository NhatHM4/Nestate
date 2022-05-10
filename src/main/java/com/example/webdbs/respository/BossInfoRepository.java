package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.BossInfo;
@Repository
public interface BossInfoRepository extends JpaRepository<BossInfo, Long>{

}
