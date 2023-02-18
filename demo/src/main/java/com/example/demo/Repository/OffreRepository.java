package com.example.demo.Repository;

import com.example.demo.Model.Offres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreRepository extends JpaRepository<Offres, Integer> {
}
