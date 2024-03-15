package com.mycompany.unittest.BlackJack;

public class Card {
    private boolean isFaceUp = true;
    private final Rank rank;
    private final Suit suit;
    
    public Card(Rank value, Suit suit){
        this.rank = value;
        this.suit = suit;
    }
      
    enum Suit {
        Spades("Spades"),
        Hearts("Hearts"),
        Clubs("Clubs"),
        Diamonds("Diamonds"),;
        
        private final String suitName;
        
        private Suit(String suitName){
            this.suitName = suitName;
        }
        
        public String printSuit(){
            return suitName;
        }
    }

    enum Rank{
            Ace(1),
            Two(2),
            Three(3),
            Four(4),
            Five(5),
            Six(6),
            Seven(7),
            Eight(8),
            Nine(9),
            Ten(10),
            Jack(10),
            Queen(10),
            King(10),;

            private final int rankPoint;

            private Rank(int rankValue){
                this.rankPoint = rankValue;
            }

            public int getValue(){
                return rankPoint;
            }
        }
    
    @Override
    public String toString(){
        if(this.isFaceUp){
            return " - " + this.rank + " of " + this.suit + " - ";
        }
        else{
            return " - Hidden. - ";
        }
    }
    
    public void turnFaceUp(){
        this.isFaceUp = true;
    }
    
    public void turnFaceDown(){
        this.isFaceUp = false;
    }
    
    public int getPoint(){
        return this.rank.getValue();
    }
}
