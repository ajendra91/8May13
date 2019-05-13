package com.example.Actualtor;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "emp", enableByDefault = true)
public class CustEnd {

    @ReadOperation
    public String fun(){
        return "my custom endpoint";
    }

}
