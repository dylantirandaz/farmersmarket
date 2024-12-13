package com.marketfinder.controller;

import com.marketfinder.model.FarmersMarket;
import com.marketfinder.service.FarmersMarketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/markets")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class FarmersMarketController {
    private final FarmersMarketService service;

    public FarmersMarketController(FarmersMarketService service) {
        this.service = service;
    }

    @GetMapping
    public List<FarmersMarket> getAllMarkets() {
        return service.getAllMarkets();
    }

    @GetMapping("/{id}")
    public FarmersMarket getMarketById(@PathVariable Long id) {
        return service.getMarketById(id);
    }

    @GetMapping("/day/{day}")
    public List<FarmersMarket> getMarketsByDay(@PathVariable String day) {
        return service.getMarketsByDay(day);
    }

    @PostMapping
    public FarmersMarket createMarket(@Valid @RequestBody FarmersMarket market) {
        return service.createMarket(market);
    }

    @PutMapping("/{id}")
    public FarmersMarket updateMarket(
        @PathVariable Long id,
        @Valid @RequestBody FarmersMarket market
    ) {
        return service.updateMarket(id, market);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMarket(@PathVariable Long id) {
        service.deleteMarket(id);
        return ResponseEntity.ok().build();
    }
}
