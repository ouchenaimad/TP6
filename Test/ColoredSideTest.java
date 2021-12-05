package model;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ColoredSideTest {
  Side redSide;
  Side blueSide;
  Side redSide2;

  @BeforeEach
  void initializeSides(){
    redSide = new ColoredSide(Color.RED);
    blueSide = new ColoredSide(Color.BLUE);
    redSide2 = new ColoredSide(Color.RED);
  }

  @Test
  void testColor(){
    assertThat(redSide.color()).isEqualTo(Color.RED);
    assertThat(blueSide.color()).isEqualTo(Color.BLUE);
  }

  @Test
  void testEquals(){
    assertThat(redSide2).isEqualTo(redSide2);
    assertThat(redSide).isEqualTo(redSide2);
    assertThat(redSide).isNotEqualTo(blueSide);
  }

  @Test
  void testAccept(){
    assertThat(blueSide.accept(blueSide)).isTrue();
    assertThat(blueSide.accept(redSide2)).isFalse();
    assertThat(redSide.accept(redSide2)).isTrue();
  }

  @Test
  void testCompatibleSides(){
    List<Side> sides = List.of(redSide, blueSide, redSide2);
    assertThat(blueSide.compatibleSides(sides))
            .containsExactly(blueSide)
            .hasSize(1)
            .doesNotContain(redSide);
    assertThat(redSide.compatibleSides(sides))
            .contains(redSide, redSide2)
            .hasSize(2)
            .doesNotContain(blueSide);
    assertThat(sides).containsExactly(redSide, blueSide, redSide2);
  }

  @Test
  void testToString(){
    assertThat(redSide.toString()).isEqualTo("ColoredSide{color=0xff0000ff}");
    assertThat(blueSide.toString()).isEqualTo("ColoredSide{color=0x0000ffff}");
  }
}
