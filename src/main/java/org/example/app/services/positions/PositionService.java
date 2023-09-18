package org.example.app.services.positions;

import org.example.app.controllers.positions.PositionCreateController;
import org.example.app.controllers.positions.PositionReadController;
import org.example.app.repositories.positions.PositionCreateRepository;
import org.example.app.repositories.positions.PositionReadRepository;
import org.example.app.services.Services;
import org.example.app.views.positions.PositionCreateView;
import org.example.app.views.positions.PositionReadView;

public class PositionService extends Services {

    public void createPosition() {
        PositionCreateRepository repository = new PositionCreateRepository();
        PositionCreateService service = new PositionCreateService(repository);
        PositionCreateView view = new PositionCreateView();
        PositionCreateController controller = new PositionCreateController(service, view);
        controller.createPosition();
    }

    public void readPositions() {
        PositionReadRepository repository = new PositionReadRepository();
        PositionReadService service = new PositionReadService(repository);
        PositionReadView view = new PositionReadView();
        PositionReadController controller = new PositionReadController(service, view);
        controller.readPositions();
    }
}