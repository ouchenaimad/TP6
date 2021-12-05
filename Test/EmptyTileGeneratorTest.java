package model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EmptyTileGeneratorTest {
  @Test
  void testNextTile(){
    TileGenerator tileGenerator = new EmptyTileGenerator();
    assertThat(tileGenerator.nextTile(EmptySquare.EMPTY_SQUARE)).isEqualTo(EmptyTile.EMPTY_TILE);
    assertThat(tileGenerator.nextTile(EmptySquare.EMPTY_SQUARE)).isEqualTo(EmptyTile.EMPTY_TILE);
  }
}
