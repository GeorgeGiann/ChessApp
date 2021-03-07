package com.gg.chess.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightMovement {

    private static List<Pair<Integer, Integer>> moves = Arrays.asList(
            new Pair<>(2, 1),
            new Pair<>(2, -1),
            new Pair<>(-2, 1),
            new Pair<>(-2, -1),
            new Pair<>(1, 2),
            new Pair<>(1, -2),
            new Pair<>(-1, 2),
            new Pair<>(-1, -2)
    );

    public static List<Square> getNextSquares(Square square) {
        List<Square> nextSquares = new ArrayList<>();

        for (Pair<Integer, Integer> move : moves) {
            int nextX = square.getX() + move.getKey();
            int nextY = square.getY() + move.getValue();

            if (isValidCoordinates(nextX, nextY)) {
                nextSquares.add( new Square(nextX, nextY, square));
            }
        }

        return nextSquares;
    }

    private static boolean isValidCoordinates(int x, int y) {
        if (x > 0 && x <= 8 && y > 0 && y <= 8) {
            return true;
        }

        return false;
    }
}
