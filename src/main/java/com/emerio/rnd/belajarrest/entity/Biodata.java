package com.emerio.rnd.belajarrest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Biodata{

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String firstname;
    private String lastname;
    private String address;

    //getter and setter

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFirstname()
    {
        return this.firstname;
    }
    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return this.lastname;
    }

    public void setLastname (String lastname)
    {
        this.lastname = lastname;
    }

    public String getAddress ()
    {
        return this.address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

}
