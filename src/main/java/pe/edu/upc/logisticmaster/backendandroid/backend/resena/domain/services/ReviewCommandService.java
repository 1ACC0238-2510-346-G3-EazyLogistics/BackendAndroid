package pe.edu.upc.logisticmaster.backendandroid.backend.resena.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.domain.model.ReviewAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.repositories.ReviewRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.resena.transform.ReviewDto;

import java.time.LocalDateTime;

@Service
public class ReviewCommandService {

    private final ReviewRepository repo;

    public ReviewCommandService(ReviewRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public ReviewDto create(Long hotelId, ReviewDto dto) {
        ReviewAggregate agg = new ReviewAggregate();
        agg.setHotelId(hotelId);
        agg.setRating(dto.getRating());
        agg.setComment(dto.getComment());
        agg.setRatingDate(dto.getRatingDate() != null
                ? dto.getRatingDate()
                : LocalDateTime.now());
        agg.setUsername(dto.getUsername());
        agg = repo.save(agg);

        dto.setId(agg.getId());
        dto.setHotelId(agg.getHotelId());
        dto.setRatingDate(agg.getRatingDate());
        return dto;
    }

    @Transactional
    public ReviewDto update(Long id, ReviewDto dto) {
        ReviewAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Review not found: " + id));
        agg.setRating(dto.getRating());
        agg.setComment(dto.getComment());
        agg.setRatingDate(dto.getRatingDate());
        agg.setUsername(dto.getUsername());
        repo.save(agg);

        dto.setId(agg.getId());
        dto.setHotelId(agg.getHotelId());
        return dto;
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
