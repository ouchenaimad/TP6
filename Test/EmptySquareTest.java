package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmptySquareTest {
  @Test
  void testGetTile(){
    assertThat(EmptySquare.EMPTY_SQUARE.getTile()).isEqualTo(EmptyTile.EMPTY_TILE);
  }


  @Test
  void testGetNeighbor(){
    assertThat(EmptySquare.EMPTY_SQUARE.getNeighbor(CardinalDirection.NORTH)).isEqualTo(EmptySquare.EMPTY_SQUARE);
    assertThat(EmptySquare.EMPTY_SQUARE.getNeighbor(CardinalDirection.SOOUTH)).isEqualTo(EmptySquare.EMPTY_SQUARE);
    assertThat(EmptySquare.EMPTY_SQUARE.getNeighbor(CardinalDirection.WEST)).isEqualTo(EmptySquare.EMPTY_SQUARE);
    assertThat(EmptySquare.EMPTY_SQUARE.getNeighbor(CardinalDirection.EAST)).isEqualTo(EmptySquare.EMPTY_SQUARE);

  }

}
