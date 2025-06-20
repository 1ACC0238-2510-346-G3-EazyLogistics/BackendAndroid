package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.internal.commandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveCommand;
import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveService;

@Service
public class ReserveCommandService {

    @Autowired
    private ReserveService reserveService;

    public void executeCreateReserve(ReserveCommand command) {
        reserveService.createReserve(command);
    }
}
