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
public class GameState {
    
    String gameMessage;
    List <Player> others;
    
    public static GameState fromGame(Game g,Integer playerId){
        GameState gs = new GameState();
        gs.others = new ArrayList<Player>();
        for (Player p : g.players) {
            if (p.selected == true && p.id != playerId){
                gs.others.add(p);
            }
        }
        gs.gameMessage = "Game not started";
        return gs;
    }
    public String getGameMessage() {
        return gameMessage;
    }
    
}
