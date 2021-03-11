package com.gg.chess.model.movement;


import com.gg.chess.model.Path;
import com.gg.chess.model.Square;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightMovement implements Movement{

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

    public List<Path> generatePaths(Path path) {
        List<Path> nextPaths = new ArrayList<>();

        for (Pair<Integer, Integer> move : moves) {
            int nextX = path.getLastSquare().getX() + move.getKey();
            int nextY = path.getLastSquare().getY() + move.getValue();

            if (isValidCoordinates(nextX, nextY)) {
                Square nextSquare = new Square(nextX, nextY);
                Path newPath = new Path.PathBuilder(path)
                        .addSquare(nextSquare)
                        .build();
                nextPaths.add( newPath);
            }
        }

        return nextPaths;
    }

    private static boolean isValidCoordinates(int x, int y) {
        if (x > 0 && x <= 8 && y > 0 && y <= 8) {
            return true;
        }

        return false;
    }
}
