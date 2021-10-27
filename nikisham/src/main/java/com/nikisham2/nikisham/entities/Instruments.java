package com.nikisham2.nikisham.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum Instruments {
ONE(2),TWO(22),THRE(32),four(42),five(52),six(62);

    private final int id;
}
