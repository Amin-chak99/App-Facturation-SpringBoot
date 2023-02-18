package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Factures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Fac_Id")
    private int fac_id = 1;
    @ManyToOne
    @JoinColumn(name = "Fac_Clt_Id")
    private Client client;
    @Column(name = "Fac_Date")

    private Date date;
    @Column(name = "Fac_Prix")

    private Double prix;


}
