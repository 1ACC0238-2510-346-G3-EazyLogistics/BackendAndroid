package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReserveAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // La base de datos generará el id automáticamente
    private Integer id;

    private Integer userId;
    private Integer roomId;
    private String status;
    private String startTime;
    private String endTime;

    public ReserveAggregate(Integer userId, Integer roomId, String status, String startTime, String endTime) {
        this.userId = userId;
        this.roomId = roomId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Métodos Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
