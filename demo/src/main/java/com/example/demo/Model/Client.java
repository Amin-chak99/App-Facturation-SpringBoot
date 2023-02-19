package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Integer id;

    @Column(name = "Clt_nom")
    private String name;

    @Column(name = "Clt_matricule")
    private String matricule;

    @Column(name = "Clt_adresse")
    private String adresse;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Factures> factures = new ArrayList<>();
}
