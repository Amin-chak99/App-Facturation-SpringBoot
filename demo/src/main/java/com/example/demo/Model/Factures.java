package com.example.demo.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class Factures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fac_id;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "Fac_Clt_Id", referencedColumnName = "id")
    private Client client;
    @Column(name = "Fac_Date")
    private Date date;
    @Column(name = "Fac_Prix")
    private Double prix;
    @Column(name = "Etats")
    private String etat;
    @Column(name = "Note")
    private String note;
    @Column(name = "Timber")
    private boolean timber;
    @OneToMany(mappedBy = "factures", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleFacture> article = new ArrayList<>();
}