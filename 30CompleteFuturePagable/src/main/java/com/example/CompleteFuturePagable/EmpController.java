package com.example.CompleteFuturePagable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Controller
public class EmpController {

    @Autowired
    public EmpDao ed;

    @RequestMapping("cf/{name}")
    public Emp cf(@PathVariable String name) throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<Emp> cf =ed.findByName(name);
        return cf.get(4, TimeUnit.SECONDS);
    }


    @RequestMapping("pg/{name}")
    public List<Emp> pg(@PathVariable String name){
        return ed.findByName(name,new PageRequest(1,4, Sort.Direction.ASC,"name"));
    }

    @GetMapping("/emp")
    public String getEmployees(@PageableDefault(size = 10) Pageable pageable,
                               Model model) {
        Page<Emp> page = ed.findAll(pageable);
        model.addAttribute("page", page);
        return "myemp";
    }

    @RequestMapping("/getAll")
    public List<Emp> getAll(){
        return ed.findAll();
    }

    @PostConstruct
    public void add(){
        //Emp emp1=new Emp(1,"php","10");
        //ed.save(emp1);
        Emp emp2=new Emp(2,"java","10");
        ed.save(emp2);
        Emp emp3=new Emp(3,"java","10");
        ed.save(emp3);
        Emp emp4=new Emp(4,"java","10");
        ed.save(emp4);
        Emp emp5=new Emp(5,"java","10");
        ed.save(emp5);
        Emp emp6=new Emp(6,"java","10");
        ed.save(emp6);
        Emp emp7=new Emp(7,"java","10");
        ed.save(emp7);
        Emp emp8=new Emp(8,"java","10");
        ed.save(emp8);
        Emp emp9=new Emp(9,"java","10");
        ed.save(emp9);
        Emp emp10=new Emp(10,"java","10");
        ed.save(emp10);
        Emp emp11=new Emp(11,"java","10");
        ed.save(emp11);
        Emp emp12=new Emp(12,"java","10");
        ed.save(emp12);
        Emp emp13=new Emp(13,"java","10");
        ed.save(emp13);
    }


}
