package com.example.demo.Repository;

import com.example.demo.Model.ArticleFacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleFacture, Integer> {
}
