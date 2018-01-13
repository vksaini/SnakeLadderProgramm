/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeladder;

/**
 *
 * @author viju
 */
import java.util.Random;

public class SnakeLadder {

    static int RandomFill() {
        Random r = new Random();
        int n = r.nextInt(5) + 1;
        return n;
    }

    static int move(int dice, int player) {
        int playvalue;
        playvalue = player + dice;
        if (playvalue > 99) {
            return player;
        } else {

            return playvalue;
        }
    }

    static int  match(int[] Start, int[] End, int player) {

        for (int i = 0; i < Start.length; i++) {
            if (player == Start[i]) {
                player = End[i];
                
            }
            
        }
        return player ;
    }

    static boolean haswon(int player) {

        if (player == 99) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        int board[] = new int[100];
        int SnakeStart[] = new int[]{45, 22, 77, 88, 43};
        int SnakeEnd[] = new int[]{20, 3, 21, 3, 15};
        int LadderStart[] = new int[]{23, 46, 26, 4, 17};
        int LadderEnd[] = new int[]{92, 73, 96, 33, 82};
        int player1 = 0, player2 = 0;
        int dice;
         System.out.println("now Game start.......");
        while (true) {
            
            if (haswon(player1)) {
                    System.out.println("player1 has won");
                   break ;
                }

            do {
                
                dice = RandomFill();

                player1 = move(dice, player1);
                player1 =match(SnakeStart, SnakeEnd, player1);
                player1=match(LadderStart, LadderEnd, player1);

            } while (dice == 6);
            
            if (haswon(player2)) {
                    System.out.println("player2 has won");
                    break ;
                }

            do {
                
                dice = RandomFill();

                player2 = move(dice, player2);
                player2=match(SnakeStart, SnakeEnd, player2);
                player2=match(LadderStart, LadderEnd, player2);

            } while (dice == 6);

        }
    }
}

