package com.marketfinder.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "farmers_markets")
public class FarmersMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    
    @NotBlank
    private String location;
    
    @NotBlank
    private String hours;
    
    private String dayOfWeek;
    
    @ElementCollection
    @CollectionTable(name = "market_vendor_types")
    private Set<String> vendorTypes;
    
    private boolean specialEvent;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    private double latitude;
    private double longitude;
}
