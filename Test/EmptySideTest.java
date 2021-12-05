package model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class EmptySideTest {
	
  @Test
  void testColor(){
    assertThat(EmptySide.EMPTY_SIDE.color()).isEqualTo(Color.WHITE);
  }

}
