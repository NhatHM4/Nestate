package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.ImageProductDetail;

@Repository
public interface ImageProductDetailRepository extends JpaRepository<ImageProductDetail, Long>{

}
