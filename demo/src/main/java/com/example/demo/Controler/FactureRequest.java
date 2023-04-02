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
public class FactureRequest {
    private int fac_id;
    private Double prix;
    private Date date;
    private int idclient;
    private String nomclient;
    private String etat ;
    private String note ;

    private List<Article> article ;

}
