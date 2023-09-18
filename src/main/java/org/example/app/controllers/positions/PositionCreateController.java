package org.example.app.controllers.positions;

import org.example.app.entities.Position;
import org.example.app.services.positions.PositionCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.positions.PositionCreateView;

public class PositionCreateController {

    PositionCreateView view;
    PositionCreateService service;

    public PositionCreateController(PositionCreateService service, PositionCreateView view) {
        this.service = service;
        this.view = view;
    }

    public void createPosition() {
        Position position = view.getData();
        String str = service.createPosition(position);
        view.getOutput(str);
        AppStarter.startApp();
    }
}
