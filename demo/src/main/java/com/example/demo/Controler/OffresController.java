package com.example.demo.Controler;

import com.example.demo.Model.Client;
import com.example.demo.Model.Factures;
import com.example.demo.Model.Offres;
import com.example.demo.Repository.ClientRepository;
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
    @Autowired
    private ClientRepository clientRepository;
    List<OffreRequest> offreRequests ;

    @PostMapping("/saveoffres")
    public ResponseEntity<String> saveOffres(@RequestBody OffreRequest offdata) {
        Optional<Client> per = clientRepository.findById(offdata.getIdclient());

        Offres offres = new Offres();

        offres.setPrix(offdata.getPrix());
        offres.setDate(offdata.getDate());
        offres.setClient(per.get());


        offreRepository.save(offres);
        return ResponseEntity.ok("Data saved");
    }
    @GetMapping("/qetAlloffres")
    public List<OffreRequest> getAlloffres() {
        List<OffreRequest> offreRequests = new ArrayList<>();
        List<Offres> offres = new ArrayList<>();
        offres = offreRepository.findAll();
        offres.forEach(a->{
            OffreRequest offreRequest = new OffreRequest();
            offreRequest.setOff_id(a.getRedid());
            offreRequest.setPrix(a.getPrix());
            offreRequest.setDate(a.getDate());
            offreRequest.setIdclient(a.getClient().getId());
            offreRequest.setNomclient(a.getClient().getName() );
            offreRequest.setArticle(a.getArticle());

            offreRequests.add(offreRequest);
        });
        return offreRequests;
    }

    @GetMapping("/getoffrebynid/{id}")
    public ResponseEntity<Object> getByoffre(@PathVariable int id){
        Optional<Offres> offre = offreRepository.findById(id);
        if (offre == null) {
            return ResponseEntity.notFound().build();
        }

        OffreRequest offreRequest = new OffreRequest();
        offreRequest.setOff_id(offre.get().getRedid());
        offreRequest.setPrix(offre.get().getPrix());
        offreRequest.setDate(offre.get().getDate());
        offreRequest.setIdclient(offre.get().getClient().getId());
        offreRequest.setNomclient(offre.get().getClient().getName());
        offreRequest.setArticle(offre.get().getArticle());

        return ResponseEntity.ok().body(offreRequest);
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