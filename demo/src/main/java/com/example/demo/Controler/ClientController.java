package com.example.demo.Controler;

import com.example.demo.Model.Client;
import com.example.demo.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/saveclient")
    public ResponseEntity<String> saveClient(@RequestBody Client cltData) {

        clientRepository.save(cltData);
        return ResponseEntity.ok("Data saved");
    }
    @GetMapping("/getClient")
    public List<Client> getClients(){

        ArrayList<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(x -> clients.add(x));
        return clients;
    }
    @GetMapping("/getNameClient")
    public List<String> getNameClients(){
        List<Client> clients = getClients();
        List<String> names = new ArrayList<>();
        clients.forEach(s->{
            names.add(s.getName());
        });

        return names;


    }

    @GetMapping("/getByClient/{id}")
    public Optional<Client> getByClients(@PathVariable int id){
       Optional<Client> client = clientRepository.findById(id);

        return client   ;

    }
    @DeleteMapping("/deleteclients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) {
        Client client = clientRepository.findById(Math.toIntExact(id)).orElse(null);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.delete(client);
        return ResponseEntity.ok("Client supprimé avec succès");
    }
    @GetMapping("/getmatByClient/{Name}")
    public List<Client> clientname(@PathVariable String Name){
        return clientRepository.findByName(Name);

    }

}