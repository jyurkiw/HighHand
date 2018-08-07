package com.jyurkiw.highhand;

public class Main {

    public static void main(String[] args) {
        if (args.length == 2) {
            Hand a = HandFactory.parseHand(args[0]);
            Hand b = HandFactory.parseHand(args[1]);

            Hand winner = null;
            String winnerName = null;

            String gameMsg = "Received two poker hands,\n\tPlayer A: " + a.toString() + "\n\tPlayer B: " + b.toString();

            int victoryStatus = a.compareTo(b);
            if (victoryStatus > 0) {
                winner = a;
                winnerName = "Player A";
            } else if (victoryStatus < 0) {
                    winner = b;
                    winnerName = "Player B";
            }

            if (winner != null) {
                System.out.println(gameMsg + "\nWinning Hand is " + winnerName + ": " + winner.toString());
            } else {
                System.out.println(gameMsg + "\nHands tie!");
            }
        }
    }
}
