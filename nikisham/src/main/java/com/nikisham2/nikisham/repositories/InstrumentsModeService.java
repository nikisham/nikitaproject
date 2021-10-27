package com.nikisham2.nikisham.repositories;

import com.nikisham2.nikisham.entities.Instruments;
import com.nikisham2.nikisham.repositories.impl.HashMapInstrumentsModeService;

import java.util.HashMap;

public interface InstrumentsModeService {

    static InstrumentsModeService getInstance(){return new HashMapInstrumentsModeService();}

    Instruments getInstrumentsInstrument(long chatId);

    void setInstrumentsInstrument(long chatId, Instruments instruments);
}
