package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayGridTest {
  Grid arrayGrid;
  @BeforeEach
  void init(){
	  arrayGrid = new ArrayGrid(2,2);
  }

  @Test
  void testNumberRows(){
    assertThat(arrayGrid.getNumberOfRows()).isEqualTo(2);
  }

  @Test
  void testNumberColumns(){
    assertThat(arrayGrid.getNumberOfColumns()).isEqualTo(2);
  }


}
