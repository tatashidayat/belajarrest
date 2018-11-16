package com.emerio.rnd.belajarrest.repo; 

import java.util.Optional;

import com.emerio.rnd.belajarrest.entity.Biodata;

import org.springframework.data.repository.CrudRepository;

public interface BiodataRepo extends CrudRepository<Biodata, Long> 
	{
	    Optional<Biodata> findByUsername(String name); 
	}
