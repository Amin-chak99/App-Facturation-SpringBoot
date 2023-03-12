package com.example.demo.Controler;

import com.example.demo.Model.Accompte;
import com.example.demo.Model.Client;
import com.example.demo.Model.Personnel;
import com.example.demo.Repository.AccompteRepository;
import com.example.demo.Repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController

public class AccomptController {
    @Autowired
    private AccompteRepository accompteRepository;

    @PostMapping("/saveAcompte")
    public ResponseEntity<String> saveAccompte(@RequestBody Accompte Accomptdata) {

        accompteRepository.save(Accomptdata);
        return ResponseEntity.ok("Data saved");
    }
    @GetMapping("/getAcompte")
    public List<Accompte> getAccompte(){

        ArrayList<Accompte> accomptes = new ArrayList<>();
        accompteRepository.findAll().forEach(x -> accomptes.add(x));
        return accomptes;
    }


}
