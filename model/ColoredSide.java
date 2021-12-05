package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

public class ColoredSide implements Side {

    @Override
    public Color color() {
        return color;
    }

    @Override
    public List<Side> compatibleSides(List<Side> sides) {
        List<Side> filteredList = new ArrayList<>();
        for (Side side : sides) {
            if (accept(side)) {
                filteredList.add(side);
            }
        }
        return filteredList;
    }

    @Override
    public boolean accept(Side side) {
        return color() == side.color();
    }

    private final Color color;

    public ColoredSide(Color color){
        this.color=color;
    }
}
