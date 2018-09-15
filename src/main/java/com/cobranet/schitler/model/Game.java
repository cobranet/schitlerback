/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobranet.schitler.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bratislav.petrovic
 */
public class Game {
    
    private static final String[] NAMES = {"sloba", "kostunica", "tadic","seselj","vucic"};
    private static final String[]  IMAGES ={"sloba.png", "kostunica.png", "tadic.png","seselj.png","vucic.png"};
    
    public List<Player> players;     

    public List<Player> getPlayers() {
        return players;
    }

    public boolean selectPlayer(Integer i){
           if (this.players.get(i).selected == true ) return false;
           this.players.get(i).selected = true;
           return true;                 
    }

    public Game(Integer numOfPlayers){
        players=new ArrayList<Player>();
        for ( int i=0;i<numOfPlayers;i++){
            players.add(new Player( i, NAMES[i],IMAGES[i]));
        }
    }
}   
