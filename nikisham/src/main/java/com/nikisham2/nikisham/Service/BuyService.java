package com.nikisham2.nikisham.Service;

import com.nikisham2.nikisham.entities.Buy;
import com.nikisham2.nikisham.repositories.BuyRepositories;
import org.jvnet.hk2.annotations.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BuyService {
    private BuyRepositories repositories;

    public BuyService(BuyRepositories repositories){
        this.repositories = repositories;
    }
   public List<Buy> getAll() {
        return repositories.getAll();
    }
    public void save(Buy buy){
        Objects.requireNonNull(buy);
        repositories.save(buy);
    }
}
