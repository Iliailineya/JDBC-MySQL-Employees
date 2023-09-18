package org.example.app.views.positions;

import org.example.app.entities.Position;
import org.example.app.utils.InputReader;
import org.example.app.views.ItemView;

public class PositionCreateView extends ItemView {
    private final InputReader inputReader;

    public PositionCreateView() {
        this.inputReader = new InputReader();
    }

    public Position getData() {
        System.out.print("Enter position detail: ");
        Position position = new Position();
        position.setName(inputReader.readString("Name"));
        return position;
    }
}
