package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model;

import jakarta.persistence.*;
import pe.edu.upc.logisticmaster.backendandroid.backend.user.domain.model.User;

@Entity
@Table(name = "reserve_aggregate")
public class ReserveAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer roomId;
    private String status;
    private String startTime;
    private String endTime;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ReserveAggregate(Long userId, Integer roomId, String status, String startTime, String endTime) {}

    public ReserveAggregate(Integer userId, Integer roomId, String status, String startTime, String endTime) {
        this.userId    = Long.valueOf(userId);
        this.roomId    = roomId;
        this.status    = status;
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    // getters y setters...
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getRoomId() { return roomId; }
    public void setRoomId(Integer roomId) { this.roomId = roomId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
