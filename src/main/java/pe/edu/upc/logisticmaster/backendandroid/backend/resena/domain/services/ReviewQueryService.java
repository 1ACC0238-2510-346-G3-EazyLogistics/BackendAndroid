package pe.edu.upc.logisticmaster.backendandroid.backend.resena.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.domain.model.ReviewAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.repositories.ReviewRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.transform.ReviewDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {
    private final ReviewRepository repo;

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

    public List<ReviewDto> findByMinRating(Integer min) {
        return repo.findByRatingGreaterThanEqual(min).stream()
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
        return repo.findAverageRatingByHotelId(hotelId);
    }

    private ReviewDto toDto(ReviewAggregate agg) {
        return ReviewDto.builder()
                .id(agg.getId())
                .hotelId(agg.getHotelId())
                .rating(agg.getRating())
                .comment(agg.getComment())
                .ratingDate(agg.getRatingDate())
                .username(agg.getUsername())
                .build();
    }
}
