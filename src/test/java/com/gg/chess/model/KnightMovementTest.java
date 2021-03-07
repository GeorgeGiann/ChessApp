package com.gg.chess.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KnightMovementTest {

    @Test
    public void testEightPossible() {
        Square square = new Square(4,4);
        List<Square> possibleSquares = KnightMovement.getNextSquares(square);

        Assertions.assertEquals(8, possibleSquares.size());
    }

    @Test
    public void testSixPossible() {
        Square square = new Square(7,3);
        List<Square> possibleSquares = KnightMovement.getNextSquares(square);

        Assertions.assertEquals(6, possibleSquares.size());
    }

    @Test
    public void testFourPossible() {
        Square square = new Square(1,3);
        List<Square> possibleSquares = KnightMovement.getNextSquares(square);

        Assertions.assertEquals(4, possibleSquares.size());
    }

    @Test
    public void testTwoPossible() {
        Square square = new Square(8,8);
        List<Square> possibleSquares = KnightMovement.getNextSquares(square);

        Assertions.assertEquals(2, possibleSquares.size());
    }
}
