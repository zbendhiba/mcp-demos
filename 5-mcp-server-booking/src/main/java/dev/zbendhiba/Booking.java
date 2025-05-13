package dev.zbendhiba;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking extends PanacheEntity {

    @ManyToOne
    Customer customer;
    LocalDate dateFrom;
    LocalDate dateTo;
}
