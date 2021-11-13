package com.nikisham2.nikisham.entity;

public enum Instruments {
    ONE(2),
    TWO(22),
    THREE(32),
    FOUR(42),
    FIVE(52),
    SIX(62);

    private final int id;

    Instruments(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
