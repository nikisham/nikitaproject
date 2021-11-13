package com.nikisham2.nikisham.repository;

import com.nikisham2.nikisham.entity.Instruments;
import com.nikisham2.nikisham.repository.impl.HashMapInstrumentsModeService;

public interface InstrumentsModeService {

    static InstrumentsModeService getInstance() {
        return new HashMapInstrumentsModeService();
    }

    Instruments getInstrumentsInstrument(long chatId);

    void setInstrumentsInstrument(long chatId, Instruments instruments);
}
