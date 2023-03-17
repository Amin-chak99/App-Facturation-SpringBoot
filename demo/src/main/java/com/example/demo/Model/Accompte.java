package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idper")
    private Personnel personnel;

}
