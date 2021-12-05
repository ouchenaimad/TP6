package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArraySquareTest {
  Square Square1;
  Square Square2;
  ColoredSide redSide;
  ColoredSide blueSide;
  Tile red;
  Tile blue;
  
  @BeforeEach
  void init(){
	  Square1 = new ArraySquare();
	  Square2 = new ArraySquare();
    red = new UniformTile(new ColoredSide(Color.RED));
    blue = new UniformTile(new ColoredSide(Color.BLUE));
    redSide = new ColoredSide(Color.RED);
    blueSide = new ColoredSide(Color.BLUE);
  }



  @Test
  void testEmptyTile(){
    assertThat(arraySquare1.getTile()).isEqualTo(EmptyTile.EMPTY_TILE);
  }

  @Test
  void testTile(){
    arraySquare1.put(redTile);
    arraySquare2.put(blueTile);
    assertThat(arraySquare1.getTile()).isEqualTo(red);
    assertThat(arraySquare2.getTile()).isEqualTo(blue);
  }


}
