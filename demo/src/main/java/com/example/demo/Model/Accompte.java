package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accompte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ACCid;
    @Column(name = "accompte")
    private Double accompte;
    @Column(name = "Accompte_Date")
    private Date date;
    @ManyToOne()
    @JoinColumn(name = "Acc_Id")
    private Personnel personnel;

}
