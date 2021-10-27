package com.nikisham2.nikisham.repositories;

import com.nikisham2.nikisham.DTOBuy.BuyDTO;
import org.springframework.data.repository.CrudRepository;
import com.nikisham2.nikisham.entities.Buy;

import java.util.List;

public interface BuyRepositories extends CrudRepository<BuyDTO,Long>{

    List<Buy> getAll();
    void save(Buy buy);
    void deleteAll();

}
