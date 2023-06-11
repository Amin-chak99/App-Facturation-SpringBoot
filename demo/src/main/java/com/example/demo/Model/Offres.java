package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Offres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Off_Id")
    private int redid;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "Off_Clt_Id", referencedColumnName = "id")
    private Client client;
    @Column(name = "Off_Date")
    private Date date;
    @Column(name = "Off_Prix")
    private Double prix;

    @OneToMany(mappedBy = "offres")
    private List<ArticleOffre> article = new ArrayList<>();

}
