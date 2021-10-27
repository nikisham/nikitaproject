package com.nikisham2.nikisham.repositories;

import com.nikisham2.nikisham.DTOBuy.BuyDTO;
import org.springframework.data.repository.CrudRepository;
import com.nikisham2.nikisham.entities.Buy;

public interface BuyRepositories extends CrudRepository<BuyDTO,Long> {

}
