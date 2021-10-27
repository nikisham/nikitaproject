package com.nikisham2.nikisham.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (schema = "public", name = "buy")
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;

    private String id;
    private String name;
    private String price;
    private String date;
    private String number;
    private String lot;
    private String volume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buy buy)) return false;
        return pk.equals(buy.pk) && id.equals(buy.id) && name.equals(buy.name) && price.equals(buy.price) && date.equals(buy.date) && number.equals(buy.number) && lot.equals(buy.lot) && volume.equals(buy.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, id, name, price, date, number, lot, volume);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        volume = volume;
    }
}



