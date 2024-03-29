package com.example.demo.Controler.Article;

import com.example.demo.Model.ArticleFacture;
import com.example.demo.Model.ArticleOffre;
import com.example.demo.Model.Factures;
import com.example.demo.Model.Offres;
import com.example.demo.Repository.ArticleRepository;
import com.example.demo.Repository.FacturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class ArticleFacController {
    @Autowired
    private ArticleRepository articleRepository ;
    @Autowired
    private FacturesRepository facturesRepository ;

    @GetMapping("/getArticle")
    public List<ArticleFacRequest> GetArticle(){
        List<ArticleFacRequest> articleRequests = new ArrayList<>();
        List<ArticleFacture> articles = new ArrayList<>();
        articles = articleRepository.findAll();
        articles.forEach(a -> {
            ArticleFacRequest articleRequest = new ArticleFacRequest();
            articleRequest.setId(a.getId());
            articleRequest.setDesq(a.getArtDesc());
            articleRequest.setPrix(a.getArtPrix());
            articleRequest.setQte(a.getArtQte());
            articleRequest.setIdFac(a.getFactures().getFac_id());

            articleRequests.add(articleRequest);

        });


        return articleRequests;
    }
    @PostMapping("/saveArticle")
    public ResponseEntity<String> saveArticle(@RequestBody List<ArticleFacRequest> ArtData) {

        String successMessage = "";



        try {
            for(ArticleFacRequest a : ArtData) {
                Optional<Factures> fac = facturesRepository.findById(a.getIdFac());

                ArticleFacture article = new ArticleFacture();
                article.setArtDesc(a.getDesq());
                article.setArtQte(a.getQte());
                article.setArtPrix(a.getPrix());
                article.setFactures(fac.get());

                articleRepository.save(article);
                successMessage += "Articles ajoutés avec succès à la facture avec l'ID : " + a.getIdFac() + "\n";
            }

            return new ResponseEntity<>(successMessage, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Transactional
    @DeleteMapping("/deleteFacture/{id}")
    public void deleteFactureWithArticles(@PathVariable("id") Factures factureId) {
        try {
            // Delete articles of the offer
            List<ArticleFacture> articles = articleRepository.findByFactures(factureId);
            articleRepository.deleteAll(articles);

            // Delete the offer
            facturesRepository.deleteById(factureId.getFac_id());
        } catch (Exception e) {
            // Handle any exception that occurred during deletion
            throw new RuntimeException("Failed to delete facture with articles", e);
        }
    }

}
