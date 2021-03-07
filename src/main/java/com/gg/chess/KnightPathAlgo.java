package com.gg.chess;

import com.gg.chess.chessboard.LetterCoordinate;
import com.gg.chess.model.KnightMovement;
import com.gg.chess.model.Square;

import java.util.*;

public class KnightPathAlgo {

    private static final int THREE_STEPS = 3;

    public static void findAndPrintThreeStepsPath(Square statingSquare, Square finalSquare) {
        List<Square> path = findThreeStepsPaths(statingSquare, finalSquare);
        printResult(path);
    }

    public static List<Square> findThreeStepsPaths(Square statingSquare, Square finalSquare) {

        Queue<Square> toVisitQueue = new ArrayDeque<>();
        toVisitQueue.add(statingSquare);

        List<Square> paths = new ArrayList<>();
        boolean threeStepPathsFound = false;
        Square shortPath = null;

        while (!toVisitQueue.isEmpty()) {
            Square square = toVisitQueue.poll();

            if (square.equals(finalSquare)) {
                if (square.getDistance() == THREE_STEPS) {
                    paths.add(square);
                    threeStepPathsFound = true;
                } else if (square.getDistance() > THREE_STEPS) {
                    paths.add(square);
                    break;
                } else {
                    shortPath = square;
                }
            }

            if (square.getDistance() < THREE_STEPS || (!threeStepPathsFound && shortPath == null)) {

                List<Square> nextSquares = KnightMovement.getNextSquares(square);
                for (Square nextSquare : nextSquares) {

                        toVisitQueue.add(nextSquare);
                }
            }
        }

        if (paths.isEmpty() && shortPath != null) {
            paths.add(shortPath);
        }

        return paths;
    }

    private static void printResult(List<Square> paths) {
        if (paths.size() == 1 && paths.get(0).getDistance() != 3) {
            List<Square> path = getPathToSquare(paths.get(0));

            System.out.println("Solutions not found. Returning shortest path");
            printPath(path);
        } else {
            for (Square squarePath : paths) {
                List<Square> path = getPathToSquare(squarePath);

                printPath(path);
            }
        }
    }

    private static List<Square> getPathToSquare(Square square) {
        List<Square> path = new ArrayList<>();

        if (square.getPreviousSquare() == null) {
            return null;
        }

        path.add(square);
        while(square.getPreviousSquare() != null) {
            path.add(square.getPreviousSquare());
            square = square.getPreviousSquare();
        }

        Collections.reverse(path);

        return path;
    }

    private static void printPath(List<Square> path) {
        StringBuilder builder = new StringBuilder();

        for (Square square : path) {
            builder.append(LetterCoordinate.getLetter(square.getX()))
                    .append(square.getY())
                    .append(" -> ");
        }

        System.out.println(builder.substring(0, builder.length()-3));

    }
}