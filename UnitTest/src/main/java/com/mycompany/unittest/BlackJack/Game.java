package com.mycompany.unittest.BlackJack;

public class Game 
{
    private final Player player;
    private final Deck deck;
    private final Dealer dealer = new Dealer();
    
    public Game(Player player, Deck deck)
    {
        this.player = player;
        this.deck = deck;
        this.deck.shuffle();
    }
    
    public void startNewRound()
    {
        player.draw(deck.deal());
        dealer.draw(deck.deal());
        player.draw(deck.deal());
        dealer.drawFaceDown(deck.deal());
        player.showHand();
        dealer.showHand();
    }
    
    public void showOptions()
    {
        System.out.println("What would you like to do?");
        System.out.println("1.Hit");
        System.out.println("2.Stand");
        System.out.println("3.Double");
        if(player.getHand(player.getCurrentHand() - 1).isSplitable())
        {
            System.out.println("4.Split");
        }
    }
    
}
