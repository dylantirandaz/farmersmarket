package com.marketfinder.service;

import com.marketfinder.model.FarmersMarket;
import com.marketfinder.repository.FarmersMarketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class FarmersMarketService {
    private final FarmersMarketRepository repository;

    public FarmersMarketService(FarmersMarketRepository repository) {
        this.repository = repository;
    }

    public List<FarmersMarket> getAllMarkets() {
        return repository.findAll();
    }

    public FarmersMarket getMarketById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Market not found"));
    }

    public List<FarmersMarket> getMarketsByDay(String day) {
        return repository.findByDayOfWeek(day.toUpperCase());
    }

    public FarmersMarket createMarket(FarmersMarket market) {
        return repository.save(market);
    }

    public FarmersMarket updateMarket(Long id, FarmersMarket market) {
        FarmersMarket existing = getMarketById(id);
        existing.setName(market.getName());
        existing.setLocation(market.getLocation());
        existing.setHours(market.getHours());
        existing.setDayOfWeek(market.getDayOfWeek());
        existing.setVendorTypes(market.getVendorTypes());
        existing.setSpecialEvent(market.isSpecialEvent());
        return repository.save(existing);
    }

    public void deleteMarket(Long id) {
        repository.deleteById(id);
    }
}
