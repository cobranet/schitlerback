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
public class Action {
    String type;
    String payload;

    public Action( String type, String payload){
        this.type= type;
        this.payload= payload;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
