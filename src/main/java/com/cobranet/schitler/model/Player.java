/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobranet.schitler.model;


/**
 *
 * @author bratislav.petrovic
 */
public class Player {

    Integer id;
    String name;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
    String image;
    Boolean selected;

    public Player(Integer id, String name, String image ){
        this.id = id;
        this.name=name;
        this.image = image;
        this.selected = false;
    } 
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
    
}
