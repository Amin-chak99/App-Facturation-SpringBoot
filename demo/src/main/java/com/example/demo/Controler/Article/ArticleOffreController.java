package com.example.demo.Controler.Article;

import com.example.demo.Model.ArticleOffre;
import com.example.demo.Model.Offres;
import com.example.demo.Repository.ArticleOffRepository;
import com.example.demo.Repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class ArticleOffreController {
    @Autowired
    private ArticleOffRepository articleOffRepository ;
    @Autowired
    private OffreRepository offreRepository ;

        @GetMapping("/getArticleOffre")
    public List<ArticleOffreRequest> GArticle(){
        List<ArticleOffreRequest> articleRequests = new ArrayList<>();
        List<ArticleOffre> articles = new ArrayList<>();
        articles = articleOffRepository.findAll();
        articles.forEach(a -> {
            ArticleOffreRequest articleRequest = new ArticleOffreRequest();
            articleRequest.setId(a.getId());
            articleRequest.setDesq(a.getArtDesc());
            articleRequest.setPrix(a.getArtPrix());
            articleRequest.setQte(a.getArtQte());
            articleRequest.setIdOffre(a.getOffres().getRedid());

            articleRequests.add(articleRequest);

        });


        return articleRequests;
    }
    @PostMapping("/saveArticleOffre")

    public ResponseEntity<String> svArticle(@RequestBody List<ArticleOffreRequest> ArtData) {

        String successMessage = "";



        try {
            for(ArticleOffreRequest a : ArtData) {
                Optional<Offres> off = offreRepository.findById(a.getIdOffre());

                ArticleOffre article = new ArticleOffre();
                article.setArtDesc(a.getDesq());
                article.setArtQte(a.getQte());
                article.setArtPrix(a.getPrix());
                article.setOffres(off.get());

                articleOffRepository.save(article);
                successMessage += "Articles ajoutés avec succès à l'offre avec l'ID : " + a.getIdOffre() + "\n";
            }

            return new ResponseEntity<>(successMessage, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Transactional
    @DeleteMapping("/deleteoffres/{id}")
    public void deleteOfferWithArticles(@PathVariable("id")  Offres offerId) {
        try {
            // Delete articles of the offer
            List<ArticleOffre> articles = articleOffRepository.findByOffres(offerId);
            articleOffRepository.deleteAll(articles);

            // Delete the offer
            offreRepository.deleteById(offerId.getRedid());
        } catch (Exception e) {
            // Handle any exception that occurred during deletion
            throw new RuntimeException("Failed to delete offer with articles", e);
        }
    }



}
