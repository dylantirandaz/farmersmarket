package com.marketfinder.repository;

import com.marketfinder.model.FarmersMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FarmersMarketRepository extends JpaRepository<FarmersMarket, Long> {
    List<FarmersMarket> findByDayOfWeek(String dayOfWeek);
    List<FarmersMarket> findByVendorTypesContaining(String vendorType);
    List<FarmersMarket> findByLocationContaining(String location);
}
