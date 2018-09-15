/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobranet.schitler.controller;

import com.cobranet.schitler.model.Action;
import com.cobranet.schitler.model.Game;
import com.cobranet.schitler.model.GameState;
import com.cobranet.schitler.model.Player;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;    
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
/**
 *
 * @author bratislav.petrovic
 */
@RestController
public class PlayerCtrl {
    private Game game;
    
    private static final Logger log = LoggerFactory.getLogger(PlayerCtrl.class);  
 
    @Autowired
    private SimpMessagingTemplate webSocket;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping ("/game/{playerid}")
    public GameState gameforplayer(@PathVariable Integer playerid ){
        return GameState.fromGame(game, playerid);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping ("/players/select/{id}")
    public Action selectPlayer(@PathVariable Integer id ){
         Gson gson = new Gson();
        if (!game.selectPlayer(id) ){
            Action a = new Action("SELECTED_PLAYER","NONE");
            return a;
        }
        GameState gs = GameState.fromGame(game,id);
        Action b = new Action("SELECTED_PLAYERS",  gson.toJson( gs ));
        log.info("SEND MESSAGE NEW PLAYER");
        this.sendMessageToAllUsers(b);
        // webSocket.convertAndSend( "/topic/loby" , b);
       return b;
    }
    
    
    public void sendMessageToAllUsers(Action action){
        for(Player p: game.players ){
            webSocket.convertAndSend( "/topic/" + p.getId() , action);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping ("/players/newgame")
    public Action newGame( ){
        Gson gson = new Gson();
        game = new Game(5);
       
        Action b = new Action("NEW_GAME",  gson.toJson("game"));
        webSocket.convertAndSend( "/topic/loby" , b);
        return b;
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping ("/players")
    public  List<Player> getPlayers(){
        if (game == null ){
            game = new Game(5);
        }
        return game.getPlayers();
    }
}
