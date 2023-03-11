package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Per_Id")
    private int perid;
    @Column(name = "Nom_Prenom_Per")
    private String nom_prenom;
    @Column(name = "Salaire-Per")
    private double Salaire;
    @Column(name = "Accompte_Per")
    private Double Accompte;
    @Column(name = "Date_Accompte")
    private Date date;



}
