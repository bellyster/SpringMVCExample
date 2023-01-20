package com.exampleMVC.MVC.DAO;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(boolean trip){
        if(trip){
            throw new RuntimeException("Major Accident! Highway Closed!");
        }
        //Simular un delay
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Expect heavy traffic this morning!";
    }
}
