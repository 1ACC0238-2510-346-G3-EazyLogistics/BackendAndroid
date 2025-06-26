package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.interfaces.rest.transform;

import pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model.ReserveAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.interfaces.rest.transform.UserDto;

public class ReserveDto {
    private Integer id;
    private Integer roomId;
    private String status;
    private String startTime;
    private String endTime;
    private UserDto user;

    public ReserveDto(ReserveAggregate r) {
        this.id        = r.getId();
        this.roomId    = r.getRoomId();
        this.status    = r.getStatus();
        this.startTime = r.getStartTime();
        this.endTime   = r.getEndTime();
        if (r.getUser() != null) {
            this.user = new UserDto(r.getUser());
        }
    }

    // getters...
    public Integer getId() { return id; }
    public Integer getRoomId() { return roomId; }
    public String getStatus() { return status; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public UserDto getUser() { return user; }
}
