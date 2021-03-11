package com.gg.chess;

import com.gg.chess.chessboard.InvalidPositionException;
import com.gg.chess.model.Square;
import com.gg.chess.chessboard.SquareUtil;
import com.gg.chess.model.movement.KnightMovement;
import com.gg.chess.model.movement.Movement;

import java.util.Scanner;

public class ChessApplication {

    public final static int DISTANCE = 3;

    public static void main(String[] args) {

        System.out.println("Enter starting chessboard:");
        Square startingSquare = readPosition();

        System.out.println("Enter final chessboard:");
        Square finalSquare = readPosition();

        Movement knightMovement = new KnightMovement();
        KnightPathAlgo.executeAndPrint(startingSquare, finalSquare, knightMovement, DISTANCE);
    }

    private static Square readPosition() {
        boolean invalidPosition = true;
        Scanner scanner = new Scanner(System.in);
        Square square = null;

        while(invalidPosition) {
            String position = scanner.nextLine();
            try {
                square = SquareUtil.createSquare(position);
                invalidPosition = false;
            } catch (InvalidPositionException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again: ");
            }
        }
        return square;
    }
}
