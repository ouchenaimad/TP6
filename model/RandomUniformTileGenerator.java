package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;

public class RandomUniformTileGenerator implements TileGenerator{
    private final List<Tile> tiles;
    private final Random randomGenerator;

    public RandomUniformTileGenerator(List<Color> colors, Random randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.tiles = new ArrayList<>();
        for (Color color : colors) {
            tiles.add(new UniformTile(new ColoredSide(color)));
        }
    }

    @Override
    public Tile nextTile(Square square) {
        return RandomUtil.randomElement(tiles, randomGenerator);
    }
}
