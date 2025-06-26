package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model;

public class ReserveCommand {
    private Long userId;
    private Integer roomId;
    private String status;
    private String startTime;
    private String endTime;

    // Constructor
    public ReserveCommand(Long userId, Integer roomId, String status, String startTime, String endTime) {
        this.userId = userId;
        this.roomId = roomId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters y Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
