package com.example.demo.Controler;

import com.example.demo.Model.Personnel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccompteRequest {

    private int ACCid;

    private Double accompte;

    private Date date;

    private int idper;
}
