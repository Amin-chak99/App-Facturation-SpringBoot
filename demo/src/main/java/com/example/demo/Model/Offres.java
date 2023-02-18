package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table
public class Offres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @Column(name = "Off_Id")
    private int redid;
    @ManyToOne
    @JoinColumn(name = "Off_Clt_Id", referencedColumnName = "id")
    @Getter
    @Setter
    private Client client;
    @Column(name = "Off_Date")
    @Getter
    @Setter
    private Date date;
    @Column(name = "Off_Prix")
    @Getter
    @Setter
    private Double prix;


}
