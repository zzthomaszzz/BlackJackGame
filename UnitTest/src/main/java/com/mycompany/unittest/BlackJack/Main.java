package com.mycompany.unittest.BlackJack;
        
public class Main 
{
    public static void main(String[] args)
    {
        Deck deck = new Deck(1);
        deck.shuffle();
        deck.showCards();
    }
}
