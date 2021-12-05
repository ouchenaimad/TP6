package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstrainedRotatedTruchetTileGeneratorTest {
  @Test
  void testNextTile(){
    Side redSide = new ColoredSide(Color.RED);
    Side blueSide = new ColoredSide(Color.BLUE);

    Tile redTile = new UniformTile(redSide);

    Square square = new ArraySquare();
    Square northNeighbor = new ArraySquare();
    Square westNeighbor = new ArraySquare();

    northNeighbor.put(redTile);
    westNeighbor.put(redTile);

    square.setNeighbor(northNeighbor, CardinalDirection.NORTH);
    square.setNeighbor(westNeighbor, CardinalDirection.WEST);

    TileGenerator tileGenerator = new ConstrainedRotatedTruchetTileGenerator(Color.BLUE, Color.RED, new Random(0));

    for(int index = 0; index < 10; index++){
      Tile tile = tileGenerator.nextTile(square);
      assertThat(tile.side(CardinalDirection.NORTH)).isEqualTo(redSide);
      assertThat(tile.side(CardinalDirection.WEST)).isEqualTo(redSide);
      assertThat(tile.side(CardinalDirection.EAST)).isEqualTo(blueSide);
      assertThat(tile.side(CardinalDirection.SOUTH)).isEqualTo(blueSide);
    }
  }
}
