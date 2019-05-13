package com.example.Actualtor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {


    @Override
    public Health health(){
        return fun()==true? Health.up().withDetail("success","this is up").build():
                Health.down().withDetail("success","this is up").build();
    }

    private boolean fun() {
        return true;
    }


    /*@Override
    public Health health(){
        return Health.up().withDetail("success","this is up").build();
    }*/


}
