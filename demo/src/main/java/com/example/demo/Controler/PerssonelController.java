package com.example.demo.Controler;
import com.example.demo.Model.Personnel;
import com.example.demo.Repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController

public class PerssonelController {
    @Autowired
    private PersonnelRepository personnelRepository;

    @PostMapping("/savepersonnel")
    public ResponseEntity<String> savePersonnel(@RequestBody Personnel personneldata) {

        personnelRepository.save(personneldata);
        return ResponseEntity.ok("Data saved");
    }
    @GetMapping("/getpersonnel")
    public List<Personnel> getPersonnel(){
        ArrayList<Personnel> personnels = new ArrayList<>();
        personnelRepository.findAll().forEach(x -> personnels.add(x));
        return personnels;
    }
    @GetMapping("/getNamepersonnel")
    public List<String> getNamePersonnel(){
        List<Personnel> clients = getPersonnel();
        List<String> names = new ArrayList<>();
        clients.forEach(s->{
            names.add(s.getNomprenom());
        });

        return names;


    }

    @GetMapping("/getBypersonnel/{id}")
    public Optional<Personnel> getByPersonnel(@PathVariable int id){
        Optional<Personnel> personnel = personnelRepository.findById(id);

        return personnel   ;

    }
    @DeleteMapping("/deletepersonnel/{id}")
    public ResponseEntity<String> deletepersonnel(@PathVariable("id") Long id) {
        Personnel personnel = personnelRepository.findById(Math.toIntExact(id)).orElse(null);
        if (personnel == null) {
            return ResponseEntity.notFound().build();
        }
        personnelRepository.delete(personnel);
        return ResponseEntity.ok("Personnel supprimé avec succès");
    }
}
