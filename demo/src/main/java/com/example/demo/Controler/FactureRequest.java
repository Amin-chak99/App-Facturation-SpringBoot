package com.example.demo.Controler;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
}
