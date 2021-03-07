package com.gg.chess.chessboard;

public class PositionValidator {

    public static void validatePosition(String inputPosition) throws InvalidPositionException {
        if (inputPosition.length() != 2) {
            throw new InvalidPositionException("Position must be consisted of 2 chars");
        }

        try {
            LetterCoordinate.valueOf(inputPosition.substring(0,1).toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidPositionException("Invalid char " + inputPosition.substring(0,1) + " must be A-H");
        }

        Integer numericCoordinate;
        try {
            numericCoordinate = Integer.valueOf(inputPosition.substring(1,2));
        } catch (NumberFormatException e) {
            throw new InvalidPositionException("Invalid number " + inputPosition.substring(1,2));
        }

        if (numericCoordinate <= 0 || numericCoordinate > 8) {
            throw new InvalidPositionException("Invalid number " + inputPosition.substring(1,2) + " should be < 8");
        }

    }
}
