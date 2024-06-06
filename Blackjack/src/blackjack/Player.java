package blackjack;

import java.util.ArrayList;

public class Player
{
    private int money;
    private String name;
    private ArrayList<Card> hand  = new ArrayList<>();
    
    public Player(String name, int money)
    {
        this.name = name;
        this.money = money;
    }

    public void add(Card card)
    {
        this.hand.add(card);
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    public String getName(){
        return name;
    }
    
    public int getMoney(){
        return money;
    }
    
    public int addMoney(int amount){
        if(money - amount < 0){
            return money;
        }
        else{
            return money - amount;
        }
    }

}
