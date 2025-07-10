package pe.edu.upc.logisticmaster.backendandroid.backend.hotel.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.domain.model.HotelAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.repositories.HotelRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.hotel.transform.HotelDto;

@Service
public class HotelCommandService {

    private final HotelRepository repo;

    public HotelCommandService(HotelRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public HotelDto create(HotelDto dto) {
        HotelAggregate agg = new HotelAggregate();
        agg.setName(dto.getName());
        agg.setDescription(dto.getDescription());
        agg.setFeatures(dto.getFeatures());
        agg.setIsPremium(dto.getIsPremium());
        agg.setLatitude(dto.getLatitude());
        agg.setLongitude(dto.getLongitude());
        agg.setImageUrl(dto.getImageUrl());
        agg.setCity(dto.getCity());
        agg.setCountry(dto.getCountry());
        agg.setAddress(dto.getAddress());
        agg.setPricePerNight(dto.getPricePerNight());
        agg.setRating(dto.getRating());
        agg = repo.save(agg);

        dto.setId(agg.getId());
        return dto;
    }

    @Transactional
    public HotelDto update(Long id, HotelDto dto) {
        HotelAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found: " + id));
        agg.setName(dto.getName());
        agg.setDescription(dto.getDescription());
        agg.setFeatures(dto.getFeatures());
        agg.setIsPremium(dto.getIsPremium());
        agg.setLatitude(dto.getLatitude());
        agg.setLongitude(dto.getLongitude());
        agg.setImageUrl(dto.getImageUrl());
        agg.setCity(dto.getCity());
        agg.setCountry(dto.getCountry());
        agg.setAddress(dto.getAddress());
        agg.setPricePerNight(dto.getPricePerNight());
        agg.setRating(dto.getRating());
        repo.save(agg);
        return dto;
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
