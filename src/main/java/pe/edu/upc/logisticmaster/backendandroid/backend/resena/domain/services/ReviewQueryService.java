package pe.edu.upc.logisticmaster.backendandroid.backend.resena.domain.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.domain.model.ReviewAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.repositories.ReviewRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.transform.ReviewDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewQueryService {

    private final ReviewRepository repo;

    public ReviewQueryService(ReviewRepository repo) {
        this.repo = repo;
    }

    public ReviewDto findById(Long id) {
        ReviewAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Review not found: " + id));
        return toDto(agg);
    }

    public List<ReviewDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<ReviewDto> findByHotel(Long hotelId) {
        return repo.findByHotelId(hotelId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<ReviewDto> findByMinRating(Integer minRating) {
        return repo.findByRatingGreaterThanEqual(minRating).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<ReviewDto> findByDateRange(LocalDateTime from, LocalDateTime to) {
        return repo.findByRatingDateBetween(from, to).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<ReviewDto> searchByComment(String text) {
        return repo.findByCommentContainingIgnoreCase(text).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Double getAverageRating(Long hotelId) {
        Double avg = repo.findAverageRatingByHotelId(hotelId);
        return avg != null ? avg : 0.0;
    }

    private ReviewDto toDto(ReviewAggregate agg) {
        ReviewDto dto = new ReviewDto();
        dto.setId(agg.getId());
        dto.setHotelId(agg.getHotelId());
        dto.setRating(agg.getRating());
        dto.setComment(agg.getComment());
        dto.setRatingDate(agg.getRatingDate());
        dto.setUsername(agg.getUsername());
        return dto;
    }
}
