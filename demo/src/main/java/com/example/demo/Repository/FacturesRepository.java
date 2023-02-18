package com.example.demo.Repository;

import com.example.demo.Model.Factures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturesRepository extends JpaRepository<Factures, Integer> {
}
