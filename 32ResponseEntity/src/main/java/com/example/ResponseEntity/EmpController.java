package com.example.ResponseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {

    public List<Emp> lst =new ArrayList<Emp>();

    @PostConstruct
    public void add(){
        lst.add(new Emp(1,"java","25"));
        lst.add(new Emp(2,"php","5"));
        lst.add(new Emp(3,"dot","55"));
        lst.add(new Emp(4,"net","5"));
        lst.add(new Emp(5,"c++","500"));
    }


    @RequestMapping("/getAll")
    public ResponseEntity<Object> getAll(){
        EmpRes<List<Emp>> res= new EmpRes<List<Emp>>(lst,"success");
        return new ResponseEntity<Object>(res, HttpStatus.MULTI_STATUS);
    }

    @RequestMapping("getId/{id}")
    public ResponseEntity<Object> getId(@PathVariable int id){
        Emp emp =lst.get(id);
        EmpRes<Emp> res = new EmpRes<Emp>(emp,"success");
        return new ResponseEntity<Object>(res,HttpStatus.ACCEPTED);
    }

    @RequestMapping("/getAll2")
    public ResponseEntity<Object> getAll2(){
        EmpReponse res= new EmpReponse(lst,"success");
        return new ResponseEntity<Object>(res, HttpStatus.MULTI_STATUS);
    }

    @RequestMapping("getId2/{id}")
    public ResponseEntity<Object> getId2(@PathVariable int id){
        Emp emp =lst.get(id);
        EmpReponse res = new EmpReponse(emp,"success");
        return new ResponseEntity<Object>(res,HttpStatus.ACCEPTED);
    }


}
