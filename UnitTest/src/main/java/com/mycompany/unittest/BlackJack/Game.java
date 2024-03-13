package com.mycompany.unittest.BlackJack;

public class Game 
{
    private final Player player;
    private final Deck deck;
    private final Dealer dealer = new Dealer();
    private boolean roundEnd = false;
    
    public Game(Player player, Deck deck)
    {
        System.out.println("Enter 0 to exit the game anytime");
        this.player = player;
        this.deck = deck;
        this.deck.shuffle();
    }
    
    public Player getPlayer()
    {
        return this.player;
    }
    
    public void setRoundEnd(boolean status)
    {
        this.roundEnd = status;
    }
    
    public boolean getRoundEnd()
    {
        return this.roundEnd;
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
        if(player.getCurrentHand().isSplitable())
        {
            System.out.println("4.Split");
        }
    }
    
    public void perform(int input)
    {
        if(input == 1)
        {
            player.draw(deck.deal());
            player.showHand();
            if(player.getCurrentHand().getHardTotal() > 21)
            {
                System.out.println("Busted");
                this.setRoundEnd(true);
            }
        }
    }
    
}
