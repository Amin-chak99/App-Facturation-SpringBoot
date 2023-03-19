package com.example.demo.Controler;
import com.example.demo.Model.Accompte;
import com.example.demo.Model.Client;
import com.example.demo.Model.Factures;
import com.example.demo.Model.Personnel;
import com.example.demo.Repository.ClientRepository;
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
    @Autowired
    private ClientRepository clientRepository;
    @PostMapping("/savefactures")
    public ResponseEntity<String> savefactures(@RequestBody FactureRequest FacData) {

        Optional<Client> per = clientRepository.findById(FacData.getIdclient());
        Factures factures = new Factures();

        factures.setPrix(FacData.getPrix());
        factures.setDate(FacData.getDate());
        factures.setEtat(FacData.getEtat());
        factures.setClient(per.get());


        facRepository.save(factures);
        return ResponseEntity.ok("Data saved");
    }
    @GetMapping("/qetAllFactures")
    public List<FactureRequest> getAllFactures() {
        List<FactureRequest> factureRequests = new ArrayList<>();
        List<Factures> factures = new ArrayList<>();
        factures = facRepository.findAll();
        factures.forEach(a->{
            FactureRequest factureRequest = new FactureRequest();

            factureRequest.setFac_id(a.getFac_id());
            factureRequest.setPrix(a.getPrix());

            factureRequest.setDate(a.getDate());
            factureRequest.setEtat(a.getEtat());
            factureRequest.setIdclient(a.getClient().getId());
            factureRequest.setNomclient(a.getClient().getName() );
            factureRequests.add(factureRequest);
        });

        return factureRequests;
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