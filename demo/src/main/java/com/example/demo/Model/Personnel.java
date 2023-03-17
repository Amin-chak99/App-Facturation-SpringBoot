package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String nomprenom;
    @Column(name = "Salaire-Per")
    private String Salaire;

    @OneToMany(mappedBy = "personnel")
    private  List<Accompte> accomptes = new ArrayList<>();



}
