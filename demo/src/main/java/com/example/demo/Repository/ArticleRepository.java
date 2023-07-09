package com.example.demo.Repository;

import com.example.demo.Model.ArticleFacture;
import com.example.demo.Model.ArticleOffre;
import com.example.demo.Model.Factures;
import com.example.demo.Model.Offres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleFacture, Integer> {
    List<ArticleFacture> findByFactures(Factures factures);

}
