package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EtatsModel")
public class Etats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Etats_Id_Fac")
    private int etatsIdFac;

    @Enumerated(EnumType.STRING)
    @Column(name = "Etats_Etat")
    private Etat etat;

    @ManyToOne
    @JoinColumn(name = "Fac_Id")
    private Factures factures;

    // constructors, getters, and setters
}
