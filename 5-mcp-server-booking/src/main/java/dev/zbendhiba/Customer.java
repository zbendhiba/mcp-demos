package dev.zbendhiba;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Customer extends PanacheEntity {

    String firstName;
    String lastName;
}
