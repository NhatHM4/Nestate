package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{

}
