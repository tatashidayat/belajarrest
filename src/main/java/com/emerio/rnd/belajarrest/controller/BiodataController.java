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
    BiodataController(BiodataRepo biodataRepo){
        this.biodataRepo = biodataRepo;
    }

    @RequestMapping(method = RequestMethod.PUT , value="/biodata/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Biodata> updateOne (@RequestBody Biodata biodata, @PathVariable Long id)
    {
        try
        {
            Optional<Biodata> bio = this.biodataRepo.findByUsername(biodata.getUsername());
            if (bio.isPresent())
            {
                if (biodata.getFirstname() != null)
                {
                    bio.get().setFirstname(biodata.getFirstname());
                }
                if (biodata.getLastname() != null)
                {
                    bio.get().setLastname(biodata.getLastname());
                }
                if (biodata.getAddress() != null)
                {
                    bio.get().setAddress(biodata.getAddress());
                }
                return new ResponseEntity<Biodata>(this.biodataRepo.save(bio.get()), HttpStatus.CREATED);
            } else 
            {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	
    @RequestMapping(method = RequestMethod.DELETE, value = "/biodata/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Biodata> deleteOne(@PathVariable Long id )
    {
        try
        {
            Optional<Biodata> bio = this.biodataRepo.findById(id);
            if (bio.isPresent())
            {
                this.biodataRepo.delete(bio.get());
                return new ResponseEntity<Biodata>(bio.get(), HttpStatus.OK);
            } else 
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e )
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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