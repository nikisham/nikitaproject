package com.nikisham2.nikisham.DTOBuy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuyDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private String price;

    @JsonProperty("date")
    private String date;

    @JsonProperty("number")
    private String number;

    @JsonProperty("lot")
    private String lot;

    @JsonProperty("volume")
    private String volume;


    public BuyDTO(String id, String name , String price, String date, String number, String lot, String volume){
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.number = number;
        this.lot = lot;
        this.volume = volume;
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
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "ByuDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", date='" + date + '\'' +
                ", number='" + number + '\'' +
                ", lot='" + lot + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
