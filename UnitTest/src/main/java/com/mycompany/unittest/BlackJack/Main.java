package com.mycompany.unittest.BlackJack;
import java.util.Scanner;
        
public class Main 
{
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);
        int input = 1;
        Game game = new Game(new Player("Thomas", 1000), new Deck(6));
        game.startNewRound();

        while(input != 0 && game.getRoundEnd() == false && game.getPlayer().getPlayerWin() == false)
        {
            game.showOptions();
            input = myObj.nextInt();
            game.perform(input);
        }

    }
}
