package dev.zbendhiba;

import java.time.LocalDate;
import java.util.List;


import io.quarkiverse.mcp.server.Tool;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BookingRepository implements PanacheRepository<Booking> {


    @Tool(description = "Cancel a booking")
    @Transactional
    public boolean cancelBooking(long bookingId, String customerFirstName, String customerLastName) {
        Booking booking = getBookingDetails(bookingId);
        // too late to cancel
        if (booking.dateFrom.minusDays(11).isBefore(LocalDate.now())) {
            throw new Exceptions.BookingCannotBeCancelledException(bookingId);
        }
        // too short to cancel
        if (booking.dateTo.minusDays(4).isBefore(booking.dateFrom)) {
            throw new Exceptions.BookingCannotBeCancelledException(bookingId);
        }
        delete(booking);
        return true;
    }

    @ActivateRequestContext
    @Tool(description = "List booking for a customer")
    public List<Booking> listBookingsForCustomer(String customerName, String customerSurname) {
        var found = Customer.find("firstName = ?1 and lastName = ?2", customerName, customerSurname).singleResultOptional();
        if (found.isEmpty()) {
            throw new Exceptions.CustomerNotFoundException(customerName, customerSurname);
        }
        return list("customer", found.get());
    }


    @ActivateRequestContext
    @Tool(description = "Get booking details")
    public Booking getBookingDetails(long bookingId) {
        Booking found = findById(bookingId);
        if (found == null) {
            throw new Exceptions.BookingNotFoundException(bookingId);
        }

        return found;
    }
}
