package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Art_Desc")
    private String ArtDesc;

    @Column(name = "Art_Qte")
    private double ArtQte;
    @Column(name = "Art_Prix")
    private double ArtPrix;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idFacture")
    private Factures factures;
}
