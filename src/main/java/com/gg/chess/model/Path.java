package com.gg.chess.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Path {

    private Stack<Square> squarePath;
    private int distance;

    public Path(Square square) {
        this.squarePath = new Stack<>();
        this.squarePath.push(square);
        this.distance = 0;
    }

    public Path(Path squarePath) {
        this.squarePath = (Stack) squarePath.getSquarePath().clone();
        this.distance = squarePath.getDistance();
    }

    public void addSquare(Square square) {
        squarePath.push(square);
        distance++;
    }

    public Square getLastSquare() {
        return squarePath.peek();
    }

    public Stack<Square> getSquarePath() {
        return squarePath;
    }

    public int getDistance() {
        return distance;
    }

    public List<Square> getPathAsSquareList() {
        List<Square> squaresList = new ArrayList<>();

        for (Square square : squarePath) {
            squaresList.add(square);
        }

        Collections.reverse(squaresList);

        return squaresList;
    }

    public static class PathBuilder {

        Path path;

        public PathBuilder(Path path) {
            this.path = new Path(path);
        }

        public PathBuilder addSquare(Square square) {
            this.path.addSquare(square);
            return this;
        }

        public Path build() {
            return this.path;
        }

    }
}
