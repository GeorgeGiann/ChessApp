package com.gg.chess.chessboard;

import java.util.Arrays;
import java.util.Optional;

public enum LetterCoordinate {
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H;


    public int getNumberValue() {
        return this.ordinal() + 1;
    }

    public static String getLetter(int number) {

        Optional<LetterCoordinate> letter = Arrays.stream(LetterCoordinate.values()).filter(l -> l.getNumberValue() == number).findFirst();

        if (letter.isPresent()) {
            return letter.get().name();
        } else {
            return "";
        }
    }
}
