package com.example.demo.Controler;

import com.example.demo.Model.Factures;
import com.example.demo.Repository.FacturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FacturesController {

    @Autowired
    private FacturesRepository facRepository;


    @PostMapping("/savefactures")
    public ResponseEntity<String> savefactures(@RequestBody Factures empData) {

        facRepository.save(empData);
        return ResponseEntity.ok("Data saved");
    }
    @GetMapping("/qetAllFactures")
    public List<Factures> getAllFactures() {
        System.out.println("sssssssssssssssssssssssssssssssssssssssssss");
        List<Factures> factures = new ArrayList<>();
        facRepository.findAll().forEach(x -> factures.add(x));
        System.out.println(factures);
        return factures;
    }
    @GetMapping("/getfacbynid/{id}")
    public Optional<Factures> getByFactures(@PathVariable int id){
        Optional<Factures> facture = facRepository.findById(id);

        return facture;

    }
    @DeleteMapping("/deletefacture/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {
        Factures facture = facRepository.findById(Math.toIntExact(id)).orElse(null);
        if (facture == null) {
            return ResponseEntity.notFound().build();
        }
        facRepository.delete(facture);
        return ResponseEntity.ok("facture "+id+" supprimé avec succès");
    }

}
