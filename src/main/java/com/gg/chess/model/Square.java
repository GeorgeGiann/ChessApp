package com.gg.chess.model;

public class Square {

    private int x;
    private int y;
    private Square previousSquare;
    private int distance;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = 0;
    }

    public Square(int x, int y, Square previousSquare) {
        this.x = x;
        this.y = y;
        this.previousSquare = previousSquare;
        this.distance = previousSquare.getDistance() + 1;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public Square getPreviousSquare() {
        return previousSquare;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Square)) {
            return false;
        }

        Square s = (Square) o;

        return (this.x == s.getX() && this.y == s.getY());
    }

}
