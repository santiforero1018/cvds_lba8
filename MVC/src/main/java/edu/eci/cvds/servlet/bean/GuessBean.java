package edu.eci.cvds.servlet.bean;

import java.security.DrbgParameters.Reseed;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "guessBean")
@SessionScoped
public class GuessBean {
    private int luckyNum;
    private int tries;
    private int price;
    private String state;
    private ArrayList<Integer> triesList;
    private ArrayList<Integer> luckyNumbers;

    public GuessBean(){
        restart();
    }
    public void guess(int tries){

        if (tries == this.luckyNum){
            //this.price += 100000;
            
            this.state = "WIN";
            this.tries++;
            this.triesList.add(this.tries);
            this.luckyNumbers.add(tries);
        }
        else {
            this.price -= 10000;
            this.state = "LOSE";
            this.tries++;
            this.triesList.add(this.tries);
            this.luckyNumbers.add(tries);
        }
    }

    public void restart(){
        this.luckyNum = (int)(Math.random()*20+1);
        this.luckyNumbers = new ArrayList();
        this.triesList = new ArrayList();
        this.state = "Lose";
        this.tries = 0;
        this.price = 100000;
    }
    
    public void setLuckyNum(int luckyNum) {
        this.luckyNum = luckyNum;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getLuckyNum(){
        return this.luckyNum;
    }

    public int getTries(){
        return this.tries;
    }

    public int getPrice(){
        return this.price;
    }

    public String getState(){
        return this.state;
    }

    public ArrayList<Integer> getTriesList() {
		return this.triesList;
	} 

    public ArrayList<Integer> getLuckyNumbers() {
		return this.luckyNumbers;
	}

}
