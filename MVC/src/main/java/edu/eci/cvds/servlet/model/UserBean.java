package edu.eci.cvds.servlet.model;

import java.security.DrbgParameters.Reseed;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
    private String playerName;

    public UserBean(){

    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public String enter(){
        return "guess.xhtml";
    }
}
