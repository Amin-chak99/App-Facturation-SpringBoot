package com.example.demo.Controler.Article;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleFacRequest {
    private int id;
    private double prix;
    private double qte;

    private String desq;
    private int idFac ;
}
