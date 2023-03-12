package com.example.demo.Model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Data
@Entity
@Table
public class Factures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fac_id;
    @ManyToOne()
    @JoinColumn(name = "Fac_Clt_Id", referencedColumnName = "id")
    private Client client;
    @Column(name = "Fac_Date")
    private Date date;
    @Column(name = "Fac_Prix")
    private Double prix;
    @Column(name = "Etats")
    private String etat;
}