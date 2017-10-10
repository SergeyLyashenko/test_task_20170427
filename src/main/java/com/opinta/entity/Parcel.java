package com.opinta.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Parcel {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;
    private float weight;
    private float length;
    private float width;
    private float height;
    private BigDecimal declaredPrice;
    private BigDecimal price;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parcel_id")
    private List<ParcelItem> parcelItems = new ArrayList<>();

    public Parcel(Shipment shipment, float weight, float length, BigDecimal declaredPrice, BigDecimal price) {
        this.shipment = shipment;
        this.weight = weight;
        this.length = length;
        this.declaredPrice = declaredPrice;
        this.price = price;
    }
}