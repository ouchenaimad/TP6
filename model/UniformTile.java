package model;

public class UniformTile implements Tile{
    private final Side side;

    public UniformTile(Side side){
        this.side = side;
    }

    @Override
    public Side side(CardinalDirection direction) {
        return side;
    }
}
