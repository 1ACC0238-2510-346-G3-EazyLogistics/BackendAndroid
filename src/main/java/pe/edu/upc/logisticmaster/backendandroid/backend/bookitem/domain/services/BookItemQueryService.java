package pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.model.BookItemAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.repositories.BookItemRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.transform.BookItemDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookItemQueryService {

    private final BookItemRepository repo;

    public BookItemDto findById(Long id) {
        BookItemAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
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

    /** new: todas las reservas de un hotel concreto */
    public List<BookItemDto> findByHotelId(Long hotelId) {
        return repo.findByHotelId(hotelId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /** new: reservas cuyo checkInDate esté entre from y to */
    public List<BookItemDto> findByCheckInBetween(LocalDateTime from, LocalDateTime to) {
        return repo.findByCheckInDateBetween(from, to).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private BookItemDto toDto(BookItemAggregate agg) {
        return BookItemDto.builder()
                .id(agg.getId())
                .userId(agg.getUserId())
                .hotelId(agg.getHotelId())
                .checkInDate(agg.getCheckInDate())
                .checkOutDate(agg.getCheckOutDate())
                .adults(agg.getAdults())
                .children(agg.getChildren())
                .infants(agg.getInfants())
                .nights(agg.getNights())
                .isPaid(agg.getIsPaid())
                .bookingDate(agg.getBookingDate())
                .hotelName(agg.getHotelName())
                .hotelImage(agg.getHotelImage())
                .location(agg.getLocation())
                .pricePerNight(agg.getPricePerNight())
                .taxes(agg.getTaxes())
                .totalPrice(agg.getTotalPrice())
                .paymentMethod(agg.getPaymentMethod())
                .status(agg.getStatus())
                .build();
    }
}
