package com.example.demo.Controler;

import com.example.demo.Model.Article;
import com.example.demo.Model.Client;
import com.example.demo.Model.Factures;
import com.example.demo.Repository.ArticleRepository;
import com.example.demo.Repository.FacturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository ;
    @Autowired
    private FacturesRepository facturesRepository ;

    @GetMapping("/getArticle")
    public List<ArticleRequest> GetArticle(){
        List<ArticleRequest> articleRequests = new ArrayList<>();
        List<Article> articles = new ArrayList<>();
        articles = articleRepository.findAll();
        articles.forEach(a -> {
            ArticleRequest articleRequest = new ArticleRequest();
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
    public ResponseEntity<String> saveArticle(@RequestBody ArticleRequest ArtData) {

        Optional<Factures> fac = facturesRepository.findById(ArtData.getIdFac());

        Article article = new Article();
        article.setArtDesc(ArtData.getDesq());
        article.setArtQte(ArtData.getQte());
        article.setArtPrix(ArtData.getPrix());
        article.setFactures(fac.get());

        articleRepository.save(article);
        return ResponseEntity.ok("Data saved");
    }

}
