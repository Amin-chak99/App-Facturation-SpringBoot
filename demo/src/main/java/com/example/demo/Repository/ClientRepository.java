package com.example.demo.Repository;


import com.example.demo.Model.Accompte;
import com.example.demo.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
     List<Client> findByName(String Name);

}
