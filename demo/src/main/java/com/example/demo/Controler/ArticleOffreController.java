package com.example.demo.Controler;

import com.example.demo.Model.ArticleFacture;
import com.example.demo.Model.ArticleOffre;
import com.example.demo.Model.Factures;
import com.example.demo.Model.Offres;
import com.example.demo.Repository.ArticleOffRepository;
import com.example.demo.Repository.ArticleRepository;
import com.example.demo.Repository.FacturesRepository;
import com.example.demo.Repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class ArticleOffreController {
    @Autowired
    private ArticleOffRepository articleOffRepository ;
    @Autowired
    private OffreRepository offreRepository ;

    @GetMapping("/getArticle")
    public List<ArticleOffreRequest> GetArticle(){
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
    @PostMapping("/saveArticle")
    public ResponseEntity<String> saveArticle(@RequestBody List<ArticleOffreRequest> ArtData) {

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

}
