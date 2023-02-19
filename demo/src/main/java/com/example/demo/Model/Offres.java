package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Offres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "Off_Id")
    private int redid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Off_Clt_Id", referencedColumnName = "id")

    private Client client;
    @Column(name = "Off_Date")

    private Date date;
    @Column(name = "Off_Prix")

    private Double prix;


}
