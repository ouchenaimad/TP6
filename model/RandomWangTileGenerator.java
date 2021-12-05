package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;

public class RandomWangTileGenerator implements TileGenerator{
    private final List<Side> availableSides;
    private final Random randomGenerator;

    public RandomWangTileGenerator(List<Color> colors, Random randomGenerator) {
        this.randomGenerator = randomGenerator;
        availableSides = new ArrayList<>();
        for (Color color : colors) {
            availableSides.add(new ColoredSide(color));
        }
    }

    @Override
    public Tile nextTile(Square square) {
        Side[] sides = new Side[CardinalDirection.NUMBER_OF_DIRECTIONS];
        for (int side = 0; side < CardinalDirection.NUMBER_OF_DIRECTIONS; side++) {
            sides[side] = RandomUtil.randomElement(availableSides, randomGenerator);
        }
        return new WangTile(sides);
    }
}
