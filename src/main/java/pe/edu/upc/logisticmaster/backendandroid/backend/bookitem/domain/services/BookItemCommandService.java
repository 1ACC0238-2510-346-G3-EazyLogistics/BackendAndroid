package pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.model.BookItemAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.repositories.BookItemRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.transform.BookItemDto;

@Service
@RequiredArgsConstructor
public class BookItemCommandService {

    private final BookItemRepository repo;

    @Transactional
    public BookItemDto create(BookItemDto dto) {
        BookItemAggregate agg = BookItemAggregate.builder()
                .userId(dto.getUserId())
                .hotelId(dto.getHotelId())
                .checkInDate(dto.getCheckInDate())
                .checkOutDate(dto.getCheckOutDate())
                .adults(dto.getAdults())
                .children(dto.getChildren())
                .infants(dto.getInfants())
                .nights(dto.getNights())
                .isPaid(dto.getIsPaid())
                .bookingDate(dto.getBookingDate())
                .hotelName(dto.getHotelName())
                .hotelImage(dto.getHotelImage())
                .location(dto.getLocation())
                .pricePerNight(dto.getPricePerNight())
                .taxes(dto.getTaxes())
                .paymentMethod(dto.getPaymentMethod())
                .status(dto.getStatus())
                .build();
        agg.calculateTotal();
        agg = repo.save(agg);
        dto.setId(agg.getId());
        dto.setTotalPrice(agg.getTotalPrice());
        return dto;
    }

    @Transactional
    public BookItemDto update(Long id, BookItemDto dto) {
        return repo.findById(id).map(agg -> {
            agg.setCheckInDate(dto.getCheckInDate());
            agg.setCheckOutDate(dto.getCheckOutDate());
            agg.setAdults(dto.getAdults());
            agg.setChildren(dto.getChildren());
            agg.setInfants(dto.getInfants());
            agg.setNights(dto.getNights());
            agg.setIsPaid(dto.getIsPaid());
            agg.setTaxes(dto.getTaxes());
            agg.setPaymentMethod(dto.getPaymentMethod());
            agg.setStatus(dto.getStatus());
            agg.calculateTotal();
            repo.save(agg);
            dto.setTotalPrice(agg.getTotalPrice());
            return dto;
        }).orElseThrow(() -> new IllegalArgumentException("Booking not found"));
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
