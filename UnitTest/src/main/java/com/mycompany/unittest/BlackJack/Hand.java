package com.mycompany.unittest.BlackJack;

import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> hand = new ArrayList<>();
    private int softScore;
    private int hardScore;
    private int finalScore;
    
    public ArrayList<Card> getHand(){
        return hand;
    }

    public void add(Card card) {
        hand.add(card);
    }
    
    public void showHand(){
        for(Card _card : this.hand){
            System.out.print(_card.toString());
        }
    }
    
    public void showScore(){
        this.calcScore();
        System.out.print("Score: " + this.hardScore + " ");
        if(this.softScore != 0){
            System.out.print("Soft: " + this.softScore);
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
    }
    
    public void calcFinalScore(){
        if(this.softScore > this.hardScore){
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
        if(total < 22 && hasAce){
            this.softScore = total;
        }
        else{
            this.softScore = 0;
        }
    }
    
    private void calcHardScore(){
        int total = 0;
        for(Card card : hand){
            total += card.getPoint();
        }
        this.hardScore = total;
    }
}
