package com.example.webdbs.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webdbs.entity.NewsDetail;
@Repository
public interface NewsDetailRepository extends JpaRepository<NewsDetail, Long>{

}
