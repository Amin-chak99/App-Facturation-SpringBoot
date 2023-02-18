package com.example.demo.Controler;

import com.example.demo.Model.Offres;
import com.example.demo.Repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
public class OffresController {


    @Autowired
    private OffreRepository offreRepository;


    @PostMapping("/saveoffres")
    public ResponseEntity<String> savefactures(@RequestBody Offres empData) {

        offreRepository.save(empData);
        return ResponseEntity.ok("Data saved");
    }
    @GetMapping("/qetAlloffres")
    public List<Offres> getAllFactures() {
        System.out.println("sssssssssssssssssssssssssssssssssssssssssss");
        List<Offres> offres = new ArrayList<>();
        offreRepository.findAll().forEach(x -> offres.add(x));
        System.out.println(offres);
        return offres;
    }
    @GetMapping("/getoffrebynid/{id}")
    public Optional<Offres> getByFactures(@PathVariable int id){
        Optional<Offres> offre = offreRepository.findById(id);

        return offre;

    }
    @DeleteMapping("/deleteoffre/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {
        Offres offre = offreRepository.findById(Math.toIntExact(id)).orElse(null);
        if (offre == null) {
            return ResponseEntity.notFound().build();
        }
        offreRepository.delete(offre);
        return ResponseEntity.ok("offre "+id+" supprimé avec succès");
    }
}
