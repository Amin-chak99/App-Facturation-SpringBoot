package com.example.demo.Repository;

import com.example.demo.Model.Accompte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccompteRepository extends JpaRepository<Accompte, Integer> {
    public List<Accompte> findByPersonnel_Nomprenom(String nomprenom);

}
