package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.interfaces.rest.transform;

import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveAggregate;

public class ReserveDto {
    private Integer id;
    private Integer userId;
    private Integer roomId;
    private String status;
    private String startTime;
    private String endTime;

    public ReserveDto(ReserveAggregate reserve) {
        this.id = reserve.getId();
        this.userId = reserve.getUserId();
        this.roomId = reserve.getRoomId();
        this.status = reserve.getStatus();
        this.startTime = reserve.getStartTime();
        this.endTime = reserve.getEndTime();
    }

    // Getters y Setters
}
