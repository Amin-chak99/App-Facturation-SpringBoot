package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ArticleOffre {
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
    @JoinColumn(name = "idOffre")
    private Offres offres;
}
