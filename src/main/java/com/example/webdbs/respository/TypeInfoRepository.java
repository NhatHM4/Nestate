package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.TypeInfo;
@Repository
public interface TypeInfoRepository extends JpaRepository<TypeInfo, Long>{

}
