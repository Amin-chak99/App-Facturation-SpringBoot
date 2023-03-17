package com.example.demo.Controler;

import com.example.demo.Model.Accompte;
import com.example.demo.Model.Client;
import com.example.demo.Model.Personnel;
import com.example.demo.Repository.AccompteRepository;
import com.example.demo.Repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController

public class AccomptController {
    @Autowired
    private AccompteRepository accompteRepository;
    @Autowired
    private PersonnelRepository personnelRepository;
    @PostMapping("/saveAcompte")
    public ResponseEntity<String> saveAccompte(@RequestBody AccompteRequest Accomptdata) {

        Optional<Personnel> per = personnelRepository.findById(Accomptdata.getIdper());
        Accompte accompte = new Accompte();
        accompte.setAccompte(Accomptdata.getAccompte());
        accompte.setPersonnel(per.get());
        accompte.setDate(Accomptdata.getDate());




        accompteRepository.save(accompte);
        return ResponseEntity.ok("Data saved");
    }
    @GetMapping("/getAcompte")
    public List<AccompteRequest> getAccompte(){
        AccompteRequest accompteRequest = new AccompteRequest();
        List<AccompteRequest> accompteRequests = new ArrayList<>();
        List<Accompte> accomptes = new ArrayList<>();
         accomptes = accompteRepository.findAll();
         accomptes.forEach(a->{
             accompteRequest.setDate(a.getDate());
             accompteRequest.setAccompte(a.getAccompte());
             accompteRequest.setIdper(a.getPersonnel().getPerid());
             accompteRequests.add(accompteRequest);
         });

        return accompteRequests;
    }
    @GetMapping("/NomPrenom/{Nomprenom}")
    public List<Accompte> getAccomptesByNomPrenom(@PathVariable String Nomprenom) {
        return accompteRepository.findByPersonnel_Nomprenom(Nomprenom);
    }



}
