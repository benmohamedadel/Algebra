package com.example.demo.controller;

import com.example.demo.model.HelloEntity;
import com.example.demo.model.UpdatedHelloRequest;
import com.example.demo.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class helloWorld {

    @Autowired
    private HelloRepository helloRepository; // Assurez-vous d'avoir un repository pour la classe HelloEntity

    @GetMapping("/getHello")
    @PreAuthorize(" hasAnyAuthority('USER') ")
    public ResponseEntity<String> sayHello() {
        // Récupérer la valeur de la base de données
        HelloEntity helloEntity = helloRepository.findById(1L).orElse(null); // Suppose que l'id est 1, ajustez selon votre modèle

        if (helloEntity != null) {

            return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(helloEntity.getHelloValue());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/sayHello")
    @PreAuthorize(" hasAnyAuthority('ADMIN') ")
    public ResponseEntity<String> updateHello(@RequestBody UpdatedHelloRequest  UpdateHelloRequest ) {
        String newHelloMessage = UpdateHelloRequest.getHelloMessage();

        // Find the existing helloEntity in the database
        HelloEntity helloEntity = helloRepository.findById(1L).orElse(null); // Assuming the ID is 1, adjust according to your model

        if (helloEntity != null) {
            // Update the hello message
            helloEntity.setHelloValue(newHelloMessage);
            helloRepository.save(helloEntity);
            return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Hello message updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
