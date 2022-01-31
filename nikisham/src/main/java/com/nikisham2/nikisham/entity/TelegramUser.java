package com.nikisham2.nikisham.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(schema = "public", name = "TGbot")
public class TelegramUser {
    @Id
    @Column(name = "chatId" )
    private Integer chatId;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "tool")
    private String tool;

    @Column(name = "price")
    private String price;

    @Column(name = "lot")
    private String lot;

    @Column(name = "volume")
    private String volume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelegramUser)) return false;
        TelegramUser that = (TelegramUser) o;
        return active == that.active && Objects.equals(chatId, that.chatId) && Objects.equals(tool, that.tool) && Objects.equals(price, that.price) && Objects.equals(lot, that.lot) && Objects.equals(volume, that.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, active, tool, price, lot, volume);
    }



}
