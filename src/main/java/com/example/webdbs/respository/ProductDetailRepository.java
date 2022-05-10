package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.ProductDetail;
@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long>{

}
