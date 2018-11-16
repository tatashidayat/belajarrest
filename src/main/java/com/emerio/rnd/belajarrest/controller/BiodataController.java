package com.emerio.rnd.belajarrest.controller;

import com.emerio.rnd.belajarrest.repo.BiodataRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiodataController{
    private BiodataRepo biodataRepo;
    
    @Autowired
    BiodataController(BiodataController biodataController){
        this.biodataRepo = biodataRepo;
    }
    

}