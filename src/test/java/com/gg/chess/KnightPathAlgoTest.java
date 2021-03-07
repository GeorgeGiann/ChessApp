package com.gg.chess;

import com.gg.chess.KnightPathAlgo;
import com.gg.chess.model.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KnightPathAlgoTest {

    @Test
    public void test3PathsOutcome() {
        Square stSquare = new Square(1,1);
        Square endSquare = new Square(5,6);

        List<Square> res = KnightPathAlgo.findThreeStepsPaths(stSquare, endSquare);

        Assertions.assertEquals(3, res.size());
    }

    @Test
    public void testNextSquare() {
        Square stSquare = new Square(4,4);
        Square endSquare = new Square(4,5);

        List<Square> res = KnightPathAlgo.findThreeStepsPaths(stSquare, endSquare);

        Assertions.assertEquals(12, res.size());
    }

    @Test
    public void testNextKnightMoveSquare() {
        Square stSquare = new Square(4,4);
        Square endSquare = new Square(5,6);

        List<Square> res = KnightPathAlgo.findThreeStepsPaths(stSquare, endSquare);

        Assertions.assertEquals(21, res.size());
    }

    @Test
    public void testNextSquareInCorner() {
        Square stSquare = new Square(1,1);
        Square endSquare = new Square(1,2);

        List<Square> res = KnightPathAlgo.findThreeStepsPaths(stSquare, endSquare);

        Assertions.assertEquals(2, res.size());
    }

    @Test
    public void test3MovesDistanceRandomPath() {
        Square stSquare = new Square(4,4);
        Square endSquare = new Square(8,3);

        List<Square> res = KnightPathAlgo.findThreeStepsPaths(stSquare, endSquare);

        Assertions.assertEquals(6, res.size());
        Assertions.assertEquals(3, res.get(0).getDistance());
    }

    @Test
    public void testLongShortestPath() {
        Square stSquare = new Square(1,1);
        Square endSquare = new Square(8,1);

        List<Square> res = KnightPathAlgo.findThreeStepsPaths(stSquare, endSquare);

        Assertions.assertEquals(1, res.size());
        Assertions.assertEquals(5, res.get(0).getDistance());
    }

    @Test
    public void test2MovesDistancePath() {
        Square stSquare = new Square(3,3);
        Square endSquare = new Square(6,6);

        List<Square> res = KnightPathAlgo.findThreeStepsPaths(stSquare, endSquare);

        Assertions.assertEquals(1, res.size());
        Assertions.assertEquals(2, res.get(0).getDistance());
    }

    @Test
    public void testDiagonalNextSquare() {
        Square stSquare = new Square(4,4);
        Square endSquare = new Square(5,5);

        List<Square> res = KnightPathAlgo.findThreeStepsPaths(stSquare, endSquare);

        Assertions.assertEquals(1, res.size());
        Assertions.assertEquals(2, res.get(0).getDistance());
    }
}
