package com.example.demo.Repository;

import com.example.demo.Model.ArticleOffre;
import com.example.demo.Model.Offres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleOffRepository extends JpaRepository<ArticleOffre, Integer> {
    List<ArticleOffre> findByOffres(Offres idOffre);


}
