package model;

import java.util.ArrayList;
import java.util.List;

public class ArraySquare implements Square{
    private Tile tile;
    private final Square[] neighbors = new Square[CardinalDirection.NUMBER_OF_DIRECTIONS];

    public ArraySquare() {
        tile = EmptyTile.EMPTY_TILE;
        for (int neighbor = 0; neighbor < CardinalDirection.NUMBER_OF_DIRECTIONS; neighbor++) {
            neighbors[neighbor] = EmptySquare.EMPTY_SQUARE;
        }
    }

    @Override
    public void put(Tile tile) {
        this.tile = tile;
    }

    @Override
    public Tile getTile() {
        return tile;
    }

    @Override
    public void setNeighbor(Square neighbor, CardinalDirection direction) {
        neighbors[direction.ordinal()] = neighbor;
    }

    @Override
    public Square getNeighbor(CardinalDirection direction) {
        return neighbors[direction.ordinal()];
    }

    @Override
    public List<Side> compatibleSides(List<Side> sides, CardinalDirection direction) {
        return switch (direction.ordinal()) {
            case 0 -> getTile().side(CardinalDirection.SOUTH).compatibleSides(sides);
            case 1 -> getTile().side(CardinalDirection.WEST).compatibleSides(sides);
            case 2 -> getTile().side(CardinalDirection.NORTH).compatibleSides(sides);
            case 3 -> getTile().side(CardinalDirection.EAST).compatibleSides(sides);
            default -> new ArrayList<>();
        };
    }

    @Override
    public List<Tile> compatibleTiles(List<Tile> tiles) {
        List<Tile> filteredList = new ArrayList<>();
        for (Tile tile : tiles){
            boolean myCondition = true;
            for (CardinalDirection direction : CardinalDirection.values())  {
                if (!getTile().side(direction.oppositeDirection()).accept(tile.side(direction))) {
                    myCondition = false;
                    break;
                }
            }
            if (myCondition) {
                filteredList.add(tile);
            }
        }
        return filteredList;
    }
}
