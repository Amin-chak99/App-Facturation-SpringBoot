package com.example.demo.Repository;

import com.example.demo.Model.Offres;
import com.example.demo.Model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
}
