package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.ImageNewsDetail;
@Repository
public interface ImageNewDetailRepository extends JpaRepository<ImageNewsDetail, Long>{

}
