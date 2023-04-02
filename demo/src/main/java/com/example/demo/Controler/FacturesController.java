package com.example.demo.Controler;
import com.example.demo.Model.*;
import com.example.demo.Repository.ArticleRepository;
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
    @Autowired
    private ArticleRepository articleRepository;
    List<FactureRequest> factureRequests ;
    @PostMapping("/savefactures")
    public ResponseEntity<String> savefactures(@RequestBody FactureRequest FacData) {

        Optional<Client> per = clientRepository.findById(FacData.getIdclient());

        Factures factures = new Factures();

        factures.setPrix(FacData.getPrix());
        factures.setDate(FacData.getDate());
        factures.setEtat(FacData.getEtat());
        factures.setNote(FacData.getNote());
        factures.setClient(per.get());


        facRepository.save(factures);
        return ResponseEntity.ok("Data saved");
    }
    @GetMapping("/qetAllFactures")
    public List<FactureRequest> getAllFactures() {
        factureRequests = new ArrayList<>();
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
            factureRequest.setArticle(a.getArticle());
            factureRequest.setNote(a.getNote());



           factureRequests.add(factureRequest);
        });

        return factureRequests;
    }
    @GetMapping("/getfacbynid/{id}")

    public ResponseEntity<FactureRequest> getByFactures(@PathVariable(value = "id") int id) {
        Optional<Factures> facture = facRepository.findById(id);
        if (facture == null) {
            return ResponseEntity.notFound().build();
        }

        FactureRequest factureRequest = new FactureRequest();
        factureRequest.setFac_id(facture.get().getFac_id());
        factureRequest.setPrix(facture.get().getPrix());
        factureRequest.setDate(facture.get().getDate());
        factureRequest.setEtat(facture.get().getEtat());
        factureRequest.setIdclient(facture.get().getClient().getId());
        factureRequest.setNomclient(facture.get().getClient().getName());
        factureRequest.setArticle(facture.get().getArticle());
        factureRequest.setNote(facture.get().getNote());



        return ResponseEntity.ok().body(factureRequest);
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