package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Clt_nom")
    private String name;

    @Column(name = "Clt_matricule")
    private String matricule;

    @Column(name = "Clt_adresse")
    private String adresse;

}
