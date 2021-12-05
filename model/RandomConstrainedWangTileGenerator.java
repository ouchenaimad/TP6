package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;


public class RandomConstrainedWangTileGenerator implements TileGenerator{
    private final List<Side> availableSides;
    private final Random randomGenerator;

    public RandomConstrainedWangTileGenerator(List<Color> colors, Random randomGenerator) {
        this.randomGenerator = randomGenerator;
        availableSides = new ArrayList<>();
        for (Color color : colors) {
            availableSides.add(new ColoredSide(color));
        }
    }

    @Override
    public Tile nextTile(Square square) {
        Side[] randomSides = new ColoredSide[CardinalDirection.NUMBER_OF_DIRECTIONS];
        CardinalDirection neighborDirection;
        Side neighborSide;

        for (int side = 0; side < CardinalDirection.NUMBER_OF_DIRECTIONS; side++) {
            neighborDirection = CardinalDirection.values()[side];
            neighborSide = square.getNeighbor(neighborDirection).getTile().side(neighborDirection.oppositeDirection());
            if (neighborSide.equals(EmptySide.EMPTY_SIDE)) {
                randomSides[side] = availableSides.get(randomGenerator.nextInt(availableSides.size()));
            } else {
                randomSides[side] = neighborSide;
            }
        }
        return new WangTile(randomSides);
    }
}
