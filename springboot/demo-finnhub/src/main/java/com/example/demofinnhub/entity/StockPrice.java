package com.example.demofinnhub.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "finnhub_stock_prices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockPrice {

    @Id // means primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @Column(name = "current_price", columnDefinition = "NUMERIC(15,2)")
    private double currentPrice;

    @Column(name = "day_high", columnDefinition = "NUMERIC(15,2)")
    private double dayHigh;

    @Column(name = "day_low", columnDefinition = "NUMERIC(15,2)")
    private double dayLow;

    @Column(name = "day_open", columnDefinition = "NUMERIC(15,2)")
    private double dayOpen;

    @Column(name = "prev_day_close", columnDefinition = "NUMERIC(15,2)")
    private double prevDayClose;

    // @ManyToOne
    // @JoinColumn(name = "stock_id", nullable = false)
    // private Stock123 stock123;
}