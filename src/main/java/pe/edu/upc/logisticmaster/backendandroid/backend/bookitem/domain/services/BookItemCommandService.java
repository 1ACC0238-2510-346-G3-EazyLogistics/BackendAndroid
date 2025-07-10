package pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.domain.model.BookItemAggregate;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.repositories.BookItemRepository;
import pe.edu.upc.logisticmaster.backendandroid.backend.bookitem.transform.BookItemDto;

@Service
public class BookItemCommandService {

    private final BookItemRepository repo;

    public BookItemCommandService(BookItemRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public BookItemDto create(BookItemDto dto) {
        BookItemAggregate agg = new BookItemAggregate();
        agg.setUserId(dto.getUserId());
        agg.setHotelId(dto.getHotelId());
        agg.setCheckInDate(dto.getCheckInDate());
        agg.setCheckOutDate(dto.getCheckOutDate());
        agg.setAdults(dto.getAdults());
        agg.setChildren(dto.getChildren());
        agg.setInfants(dto.getInfants());
        agg.setNights(dto.getNights());
        agg.setIsPaid(dto.getIsPaid());
        agg.setBookingDate(dto.getBookingDate());
        agg.setHotelName(dto.getHotelName());
        agg.setHotelImage(dto.getHotelImage());
        agg.setLocation(dto.getLocation());
        agg.setPricePerNight(dto.getPricePerNight());
        agg.setTaxes(dto.getTaxes());
        agg.setPaymentMethod(dto.getPaymentMethod());
        agg.setStatus(dto.getStatus());

        agg.calculateTotal();
        agg = repo.save(agg);

        dto.setId(agg.getId());
        dto.setTotalPrice(agg.getTotalPrice());
        return dto;
    }

    @Transactional
    public BookItemDto update(Long id, BookItemDto dto) {
        BookItemAggregate agg = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found: " + id));

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
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
