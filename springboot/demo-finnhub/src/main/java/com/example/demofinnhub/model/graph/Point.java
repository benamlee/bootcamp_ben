package com.example.demofinnhub.model.graph;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Point {
    
    private Price closePrice;

    private TranDayTime tranDateTime;
}
