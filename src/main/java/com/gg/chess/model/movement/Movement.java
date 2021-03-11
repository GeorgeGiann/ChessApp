package com.gg.chess.model.movement;

import com.gg.chess.model.Path;

import java.util.List;

public interface Movement {

    List<Path> generatePaths(Path path);
}
