package com.mycompany.unittest.BlackJack;
        
public class Main 
{
    public static void main(String[] args)
    {
        Game game = new Game(new Player("Thomas", 1000), new Deck(6));
        game.startNewRound();
        game.showOptions();
    }
}
