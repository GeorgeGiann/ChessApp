package com.gg.chess.model;

import com.gg.chess.model.movement.KnightMovement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KnightMovementTest {

    private KnightMovement knightMovement = new KnightMovement();

    @Test
    public void testEightPossible() {
        Square square = new Square(4,4);
        Path path = new Path(square);
        List<Path> possibleSquares = knightMovement.generatePaths(path);

        Assertions.assertEquals(8, possibleSquares.size());
    }

    @Test
    public void testSixPossible() {
        Square square = new Square(7,3);
        Path path = new Path(square);
        List<Path> possibleSquares = knightMovement.generatePaths(path);

        Assertions.assertEquals(6, possibleSquares.size());
    }

    @Test
    public void testFourPossible() {
        Square square = new Square(1,3);
        Path path = new Path(square);
        List<Path> possibleSquares = knightMovement.generatePaths(path);

        Assertions.assertEquals(4, possibleSquares.size());
    }

    @Test
    public void testTwoPossible() {
        Square square = new Square(8,8);
        Path path = new Path(square);
        List<Path> possibleSquares = knightMovement.generatePaths(path);

        Assertions.assertEquals(2, possibleSquares.size());
    }
}
