package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.ProductDetail;
@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long>{

	@Query(value = "select product_detail.*, image_product_detail.link_image from image_product_detail "
			+ "inner join product_detail \r\n"
			+ "on image_product_detail.id_product_detail = product_detail.id \r\n"
			+ "where product_detail.id = :productID",nativeQuery = true)
	ProductDetail getOnebyProductID(Long productID);
}
