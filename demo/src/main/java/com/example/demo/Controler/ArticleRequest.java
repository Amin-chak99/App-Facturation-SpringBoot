package com.example.demo.Controler;


import com.example.demo.Model.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    private int id;
    private double prix;
    private double qte;

    private String desq;
    private int idFac ;
}
