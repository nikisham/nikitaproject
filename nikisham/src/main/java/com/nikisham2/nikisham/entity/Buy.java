package com.nikisham2.nikisham.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(schema = "public", name = "buy")
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_" )
    private UUID id;

    @Column(name = "name_")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "date_")
    private String date;

    @Column(name = "number_")
    private Integer number;

    @Column(name = "lot")
    private String lot;

    @Column(name = "volume")
    private String volume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Buy buy = (Buy) o;
        return id != null && Objects.equals(id, buy.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}



