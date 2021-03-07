package com.gg.chessboard;

import com.gg.chess.chessboard.InvalidPositionException;
import com.gg.chess.chessboard.PositionValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionValidatorTest {

    @Test
    public void testWrongALength() {
        String position = "D91";

        Assertions.assertThrows(InvalidPositionException.class, () -> PositionValidator.validatePosition(position));
    }

    @Test
    public void testWrongAlphabetical() {
        String position = "Z5";

        Assertions.assertThrows(InvalidPositionException.class, () -> PositionValidator.validatePosition(position));
    }

    @Test
    public void testWrongNumerical() {
        String position = "D9";

        Assertions.assertThrows(InvalidPositionException.class, () -> PositionValidator.validatePosition(position));
    }

    @Test
    public void testNaN() {
        String position = "DQ";

        Assertions.assertThrows(InvalidPositionException.class, () -> PositionValidator.validatePosition(position));
    }

}
