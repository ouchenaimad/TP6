package model;

import java.util.Iterator;

public class ArrayGrid implements Grid{
    private final Square[][] squares;
    private final int numOfRows;
    private final int numOfColumns;

    public ArrayGrid(int numOfRows, int numOfColumns) {
        squares = new Square[numOfRows][numOfColumns];
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        for(int row = 0; row < numOfRows; row++) {
            for (int column = 0; column < numOfColumns; column++) {
                squares[row][column] = new ArraySquare();
            }
        }

        for(int row = 0; row < numOfRows; row++) {
            for (int column = 0; column < numOfColumns; column++) {
                if (row - 1 >= 0) {
                    squares[row][column].setNeighbor(squares[row - 1][column], CardinalDirection.NORTH);
                }
                if (column + 1 < numOfColumns) {
                    squares[row][column].setNeighbor(squares[row][column + 1], CardinalDirection.EAST);
                }
                if (row + 1 < numOfRows) {
                    squares[row][column].setNeighbor(squares[row + 1][column], CardinalDirection.SOUTH);
                }
                if (column - 1 >= 0) {
                    squares[row][column].setNeighbor(squares[row][column - 1], CardinalDirection.WEST);
                }
            }
        }
    }

    public Iterator<Square> iterator() {
        return new SquareGridIterator();
    }

    @Override
    public Square getSquare(int rowIndex, int columnIndex) {
        return squares[rowIndex][columnIndex];
    }

    @Override
    public int getNumberOfRows() {
        return numOfRows;
    }

    @Override
    public int getNumberOfColumns() {
        return numOfColumns;
    }

    @Override
    public void fill(TileGenerator tileGenerator) {
        for (int row = 0; row < numOfRows; row++) {
            for (int column = 0; column < numOfColumns; column++) {
                squares[row][column].put(tileGenerator.nextTile(squares[row][column]));
            }
        }
    }
}
