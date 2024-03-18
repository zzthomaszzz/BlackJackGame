package com.mycompany.unittest.BlackJack;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> hand = new ArrayList<>();
    private int softScore;
    private int hardScore;
    private int finalScore;
    
    public boolean hasAce(){
        for(Card card : hand){
            if(card.getPoint() == 1){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }

    public void add(Card card) {
        hand.add(card);
    }
    
    public void show(){
        for(Card _card : this.hand){
            System.out.print(_card.toString());
        }
    }
    
    public int getHardScore(){
        return this.hardScore;
    }
    
    public int getSoftScore(){
        return this.softScore;
    }
    
    public int getFinalScore(){
        return this.finalScore;
    }
    
    public void calcScore(){
        this.calcHardScore();
        this.calcSoftScore();
        this.calcFinalScore();
    }
    
    private void calcFinalScore(){
        if(this.softScore > this.hardScore && this.softScore < 22){
            this.finalScore = this.softScore;
        }
        else{
            this.finalScore = this.hardScore;
        }
    }
    
    private void calcSoftScore(){
        boolean hasAce = false;
        int total = 0;
        for(Card card : hand){
            total += card.getPoint();
            if(card.getPoint() == 1 && !hasAce){
                total += 10;
                hasAce = true;
            }
        }
        this.softScore = total;
    }
    
    private void calcHardScore(){
        int total = 0;
        for(Card card : hand){
            total += card.getPoint();
        }
        this.hardScore = total;
    }
}
