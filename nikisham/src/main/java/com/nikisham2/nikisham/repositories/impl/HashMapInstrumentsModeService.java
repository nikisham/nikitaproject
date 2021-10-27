package com.nikisham2.nikisham.repositories.impl;

import com.nikisham2.nikisham.entities.Instruments;
import com.nikisham2.nikisham.repositories.InstrumentsModeService;

import java.util.HashMap;
import java.util.Map;

public class HashMapInstrumentsModeService implements InstrumentsModeService {
private final Map<Long, Instruments> instrumentsMap = new HashMap<>();

    public Map<Long, Instruments> getInstrumentsMap() {
        return instrumentsMap;
    }



    @Override
    public Instruments getInstrumentsInstrument(long chatId) {
        return instrumentsMap.getOrDefault(chatId,Instruments.ONE);
    }

    @Override
    public void setInstrumentsInstrument(long chatId, Instruments instruments) {
        instrumentsMap.put(chatId,instruments);
    }


}
