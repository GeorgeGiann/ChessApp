package com.gg.chess;

import com.gg.chess.chessboard.InvalidPositionException;
import com.gg.chess.model.Square;
import com.gg.chess.chessboard.SquareUtil;

import java.util.Scanner;

public class ChessApplication {

    public static void main(String[] args) {

        System.out.println("Enter starting chessboard:");
        Square startingSquare = readPosition();

        System.out.println("Enter final chessboard:");
        Square finalSquare = readPosition();

        KnightPathAlgo.findAndPrintThreeStepsPath(startingSquare, finalSquare);
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
