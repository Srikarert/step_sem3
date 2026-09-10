/**
 * Program Name  : RockPaperScissorsGame
 * Class Name    : RockPaperScissorsGame
 * Description   : Day 1 Live-Coding Session - Problem 1: Rock-Paper-Scissors Game.
 *                 Simulates N rounds between player and computer, records outcomes,
 *                 and displays summary scoreboard and win percentage.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

import java.util.Random;

import java.util.Scanner;

public class RockPaperScissorsGame {

    private static final String[] VALID_MOVES = {"Rock", "Paper", "Scissors"};

    public static String generateComputerMove() {
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(VALID_MOVES.length);
        return VALID_MOVES[randomIndex];
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            throw new IllegalArgumentException("Moves cannot be null");
        }
        String normalizedPlayer = playerMove.trim();
        String normalizedComputer = computerMove.trim();

        if (normalizedPlayer.equalsIgnoreCase(normalizedComputer)) {
            return "Draw";
        }

        if ((normalizedPlayer.equalsIgnoreCase("Rock") && normalizedComputer.equalsIgnoreCase("Scissors")) ||
            (normalizedPlayer.equalsIgnoreCase("Paper") && normalizedComputer.equalsIgnoreCase("Rock")) ||
            (normalizedPlayer.equalsIgnoreCase("Scissors") && normalizedComputer.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void printSummaryTable(int totalRounds, String[] playerMoves, String[] computerMoves, String[] roundResults) {
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-8s | %-15s | %-15s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-8d | %-15s | %-15s | %-15s%n", (i + 1), playerMoves[i], computerMoves[i], roundResults[i]);
        }
        System.out.println("------------------------------------------------------------------------");
    }

    public static void printFinalScoreboard(int wins, int losses, int draws, int totalRounds) {
        double winPercentage = (totalRounds > 0) ? ((double) wins / totalRounds) * 100.0 : 0.0;
        System.out.println("Final Summary (after " + totalRounds + " rounds):");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        final int totalRounds = 5;
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] roundResults = new String[totalRounds];

        String[] demoMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        int playerWinsCount = 0;
        int computerWinsCount = 0;
        int drawsCount = 0;

        System.out.println("==================================================");
        System.out.println("        ROCK-PAPER-SCISSORS ARCADE SIMULATOR      ");
        System.out.println("===================================================");

        for (int round = 0; round < totalRounds; round++) {
            String currentPlayerMove = demoMoves[round];
            String currentComputerMove = generateComputerMove();
            String result = playRound(currentPlayerMove, currentComputerMove);

            playerMoves[round] = currentPlayerMove;
            computerMoves[round] = currentComputerMove;
            roundResults[round] = result;

            if (result.equals("Player Wins")) {
                playerWinsCount++;
            } else if (result.equals("Computer Wins")) {
                computerWinsCount++;
            } else {
                drawsCount++;
            }

            System.out.printf("Round %d -> Player: %s, Computer: %s => %s%n",
                    (round + 1), currentPlayerMove, currentComputerMove, result);
        }

        printSummaryTable(totalRounds, playerMoves, computerMoves, roundResults);
        printFinalScoreboard(playerWinsCount, computerWinsCount, drawsCount, totalRounds);
    }
}