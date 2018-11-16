package com.emerio.rnd.belajarrest.controller;

import java.util.Optional;

import com.emerio.rnd.belajarrest.entity.Biodata;
import com.emerio.rnd.belajarrest.repo.BiodataRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiodataController{
    private BiodataRepo biodataRepo;
    
    @Autowired
    BiodataController(BiodataController biodataController){
        this.biodataRepo = biodataRepo;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/biodata", produces = MediaType.APPLICATION_JSON_VALUE) 
    ResponseEntity<Iterable<Biodata>> getAll()
    {
        try
        {   
            return new ResponseEntity<Iterable<Biodata>>(this.biodataRepo.findAll(), HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/biodata/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Biodata> createOne(@PathVariable Long id)
    {
        try
        {
            return new ResponseEntity<Biodata>(this.biodataRepo.findById(id).get() , HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST , value="/biodata", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Biodata> createOne(@RequestBody Biodata biodata)
    {
        try
        {
            Optional<Biodata> bio = this.biodataRepo.findByUsername(biodata.getUsername());
            if (bio.isPresent())
            {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else 
            {
                Biodata bioSave = this.biodataRepo.save(biodata);
                return new ResponseEntity<Biodata>(bioSave, HttpStatus.CREATED);
            }
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    

}