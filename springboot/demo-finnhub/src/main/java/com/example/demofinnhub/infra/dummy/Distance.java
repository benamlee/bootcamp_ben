package com.example.demofinnhub.infra.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.Setter;

@Setter
public class Distance { // controller

    int hours;

    @Autowired
    Car car; // service

    public Distance(Car car) {
        // if null throw IAE
        this.car = car;
    }

    public int calculate() {
        return this.car.getSpeed() * this.hours;
    }

    // public static void main(String[] args) {
    //     Distance distance = new Distance(new Car(5));
    //     distance.setHours(10);
    //     System.out.println(distance.calculate()); // 50
    // }
}
