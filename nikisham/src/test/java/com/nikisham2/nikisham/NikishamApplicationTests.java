package com.nikisham2.nikisham;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NikishamApplicationTests extends BaseContainer {
    @Test
    void main() {
        assertDoesNotThrow(() -> NikishamApplication.main("--spring.profiles.active=test"));
    }

}
