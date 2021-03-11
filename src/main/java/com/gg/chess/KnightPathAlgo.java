package com.gg.chess;

import com.gg.chess.chessboard.LetterCoordinate;
import com.gg.chess.model.Path;
import com.gg.chess.model.Square;
import com.gg.chess.model.movement.Movement;

import java.util.*;

public class KnightPathAlgo {

    public static void executeAndPrint(Square statingSquare, Square finalSquare, Movement movement, int distance) {
        List<Path> path = execute(statingSquare, finalSquare, movement, distance);
        printResult(path);
    }

    public static List<Path> execute(Square statingSquare, Square finalSquare, Movement movement, int distance) {

        Queue<Path> toVisitQueue = new ArrayDeque<>();
        Path startingPath = new Path(statingSquare);
        toVisitQueue.add(startingPath);

        List<Path> paths = new ArrayList<>();
        boolean threeStepPathsFound = false;
        Path shortPath = null;

        while (!toVisitQueue.isEmpty()) {
            Path path = toVisitQueue.poll();

            Square checkingSquare = path.getLastSquare();
            if (checkingSquare.getX()== finalSquare.getX() &&
                    checkingSquare.getY() == finalSquare.getY()) {
                if (path.getDistance() == distance) {
                    paths.add(path);
                    threeStepPathsFound = true;
                } else if (path.getDistance() > distance) {
                    paths.add(path);
                    break;
                } else {
                    shortPath = path;
                }
            }

            if (path.getDistance() < distance || (!threeStepPathsFound && shortPath == null)) {

                List<Path> nextPaths = movement.generatePaths(path);
                for (Path nextPath : nextPaths) {

                        toVisitQueue.add(nextPath);
                }
            }
        }

        if (paths.isEmpty() && shortPath != null) {
            paths.add(shortPath);
        }

        return paths;
    }

    private static void printResult(List<Path> paths) {
        if (paths.size() == 1 && paths.get(0).getDistance() != 3) {
            System.out.println("Solutions not found. Returning shortest path");
            printPath(paths.get(0));
        } else {
            for (Path path : paths) {
                printPath(path);
            }
        }
    }

    private static void printPath(Path path) {
        StringBuilder builder = new StringBuilder();

        List<Square> squaresPath = path.getSquarePath();
        for (Square square : squaresPath) {
            builder.append(LetterCoordinate.getLetter(square.getX()))
                    .append(square.getY())
                    .append(" -> ");
        }

        System.out.println(builder.substring(0, builder.length()-3));

    }
}