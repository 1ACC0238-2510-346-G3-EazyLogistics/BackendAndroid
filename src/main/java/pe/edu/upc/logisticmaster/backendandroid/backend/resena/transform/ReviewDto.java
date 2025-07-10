package pe.edu.upc.logisticmaster.backendandroid.backend.resena.transform;

import java.time.LocalDateTime;

public class ReviewDto {

    private Long id;
    private Long hotelId;
    private Integer rating;
    private String comment;
    private LocalDateTime ratingDate;
    private String username;

    public ReviewDto() {}

    // Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getHotelId() { return hotelId; }
    public void setHotelId(Long hotelId) { this.hotelId = hotelId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public LocalDateTime getRatingDate() { return ratingDate; }
    public void setRatingDate(LocalDateTime ratingDate) { this.ratingDate = ratingDate; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
