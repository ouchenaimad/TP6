package controller;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import model.*;
import view.GridCanvas;

import java.util.List;
import java.util.Random;

public class GridController {
  public static final Color COLOR_FIRST_NAME_ONE = Color.RED;
  public static final Color COLOR_LAST_NAME_ONE = Color.BLUE;
  public static final Color COLOR_FIRST_NAME_TWO = Color.GREEN;
  public static final Color COLOR_LAST_NAME_TWO = Color.YELLOW;
  Random random = new Random();
  @FXML
  public GridCanvas gridCanvas;

  public void initialize() {
    clearGrid();
  }

  public void fillGrid(TileGenerator tileGenerator) {
    gridCanvas.fillGrid(tileGenerator);
  }

  public void drawGrid() {
    gridCanvas.update();
  }

  public void clearGrid(){
    fillGrid(new EmptyTileGenerator());
  }

  public void updateGrid(TileGenerator tileGenerator){
    clearGrid();
    fillGrid(tileGenerator);
    drawGrid();
  }

  @FXML
  public void updateEmptyUniformTile(){
    updateGrid(new EmptyTileGenerator());
  }

  @FXML
  public void updateFirstNameOneUniformTile(){
    updateGrid(new UniformTileGenerator(COLOR_FIRST_NAME_ONE));
  }

  @FXML
  public void updateFirstNameTwoUniformTile() {
    updateGrid(new UniformTileGenerator(COLOR_FIRST_NAME_TWO));
  }

  @FXML
  public void updateLastNameOneUniformTile(){
    updateGrid(new UniformTileGenerator(COLOR_LAST_NAME_ONE));
  }

  @FXML
  public void updateLastNameTwoUniformTile() {
    updateGrid(new UniformTileGenerator(COLOR_LAST_NAME_TWO));
  }

  @FXML
  public void updateRandomColorUniformTile(){
    updateGrid(new RandomUniformTileGenerator(List.of(COLOR_FIRST_NAME_ONE, COLOR_LAST_NAME_ONE, COLOR_LAST_NAME_TWO), random));
  }

  @FXML
  public void updateRandomTruchetTile(){
    updateGrid(new RandomRotatedTruchetTileGenerator(COLOR_FIRST_NAME_ONE, COLOR_LAST_NAME_ONE, random));
  }

  @FXML
  public void updateRandomWangTile() {
    updateGrid(new RandomWangTileGenerator(List.of(COLOR_FIRST_NAME_ONE, COLOR_LAST_NAME_ONE, COLOR_FIRST_NAME_TWO, COLOR_LAST_NAME_TWO), random));
  }

  @FXML
  public void updateRandomConstrainedWangTile() {
    updateGrid(new RandomConstrainedWangTileGenerator(List.of(COLOR_FIRST_NAME_ONE, COLOR_LAST_NAME_ONE, COLOR_FIRST_NAME_TWO, Color.YELLOW), random));
  }

  @FXML
  public void updateConstrainedTruchetTile() {
    updateGrid(new ConstrainedRotatedTruchetTileGenerator(COLOR_FIRST_NAME_ONE, COLOR_LAST_NAME_ONE, random));
  }

  @FXML
  public void updateRandomWangTileSet() {
    updateGrid(new RandomTileSetGenerator(List.of(
            new WangTile(new Side[]{new ColoredSide(COLOR_LAST_NAME_ONE), new ColoredSide(COLOR_FIRST_NAME_ONE), new ColoredSide(COLOR_FIRST_NAME_ONE), new ColoredSide(COLOR_FIRST_NAME_ONE)}),
            new WangTile(new Side[]{new ColoredSide(COLOR_LAST_NAME_TWO), new ColoredSide(COLOR_FIRST_NAME_ONE), new ColoredSide(COLOR_FIRST_NAME_ONE), new ColoredSide(COLOR_FIRST_NAME_ONE)}),
            new WangTile(new Side[]{new ColoredSide(COLOR_LAST_NAME_ONE), new ColoredSide(COLOR_FIRST_NAME_ONE), new ColoredSide(COLOR_LAST_NAME_ONE), new ColoredSide(COLOR_FIRST_NAME_TWO)}),
            new WangTile(new Side[]{new ColoredSide(COLOR_LAST_NAME_TWO), new ColoredSide(COLOR_FIRST_NAME_ONE), new ColoredSide(COLOR_LAST_NAME_ONE), new ColoredSide(COLOR_FIRST_NAME_TWO)}),
            new WangTile(new Side[]{new ColoredSide(COLOR_FIRST_NAME_ONE), new ColoredSide(COLOR_FIRST_NAME_TWO), new ColoredSide(COLOR_LAST_NAME_TWO), new ColoredSide(COLOR_FIRST_NAME_ONE)}),
            new WangTile(new Side[]{new ColoredSide(COLOR_FIRST_NAME_TWO), new ColoredSide(COLOR_FIRST_NAME_TWO), new ColoredSide(COLOR_LAST_NAME_TWO), new ColoredSide(COLOR_FIRST_NAME_ONE)}),
            new WangTile(new Side[]{new ColoredSide(COLOR_FIRST_NAME_ONE), new ColoredSide(COLOR_FIRST_NAME_TWO), new ColoredSide(COLOR_FIRST_NAME_TWO), new ColoredSide(COLOR_FIRST_NAME_TWO)}),
            new WangTile(new Side[]{new ColoredSide(COLOR_FIRST_NAME_TWO), new ColoredSide(COLOR_FIRST_NAME_TWO), new ColoredSide(COLOR_FIRST_NAME_TWO), new ColoredSide(COLOR_FIRST_NAME_TWO)})), random));

  }
}
