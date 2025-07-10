package pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.model.BookItemAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.repositories.BookItemRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.transform.BookItemDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookItemQueryService {

    private final BookItemRepository repo;

    public BookItemQueryService(BookItemRepository repo) {
        this.repo = repo;
    }

    public BookItemDto findById(Long id) {
        BookItemAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found: " + id));
        return toDto(agg);
    }

    public List<BookItemDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<BookItemDto> findByUserId(Long userId) {
        return repo.findByUserId(userId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<BookItemDto> findByHotelId(Long hotelId) {
        return repo.findByHotelId(hotelId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<BookItemDto> findByCheckInBetween(LocalDateTime from, LocalDateTime to) {
        return repo.findByCheckInDateBetween(from, to).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private BookItemDto toDto(BookItemAggregate agg) {
        BookItemDto dto = new BookItemDto();
        dto.setId(agg.getId());
        dto.setUserId(agg.getUserId());
        dto.setHotelId(agg.getHotelId());
        dto.setCheckInDate(agg.getCheckInDate());
        dto.setCheckOutDate(agg.getCheckOutDate());
        dto.setAdults(agg.getAdults());
        dto.setChildren(agg.getChildren());
        dto.setInfants(agg.getInfants());
        dto.setNights(agg.getNights());
        dto.setIsPaid(agg.getIsPaid());
        dto.setBookingDate(agg.getBookingDate());
        dto.setHotelName(agg.getHotelName());
        dto.setHotelImage(agg.getHotelImage());
        dto.setLocation(agg.getLocation());
        dto.setPricePerNight(agg.getPricePerNight());
        dto.setTaxes(agg.getTaxes());
        dto.setTotalPrice(agg.getTotalPrice());
        dto.setPaymentMethod(agg.getPaymentMethod());
        dto.setStatus(agg.getStatus());
        return dto;
    }
}
