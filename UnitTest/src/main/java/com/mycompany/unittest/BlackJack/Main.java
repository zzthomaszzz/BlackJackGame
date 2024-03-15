package com.mycompany.unittest.BlackJack;
        
public class Main {
    public static void main(String[] args){
        Game game = new Game(new Player("Thomas"), new Deck(6));
        game.startNewRound();
    }
}
