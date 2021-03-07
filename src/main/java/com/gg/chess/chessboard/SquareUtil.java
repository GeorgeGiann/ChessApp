package com.gg.chess.chessboard;

import com.gg.chess.model.Square;

public class SquareUtil {

    public static Square createSquare(String position) throws InvalidPositionException {

        PositionValidator.validatePosition(position);
        String xValue = position.substring(0,1).toUpperCase();

        String yValue = position.substring(1,2);

        int x = LetterCoordinate.valueOf(xValue).getNumberValue();
        int y = Integer.valueOf(yValue);

        return new Square(x, y );
    }

}
