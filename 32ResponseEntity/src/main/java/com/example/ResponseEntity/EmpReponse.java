package com.example.ResponseEntity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpReponse {

    public Emp emp;
    public List<Emp> lst;
    public String status;


    public EmpReponse(Emp emp, String status) {
        this.emp = emp;
        this.status = status;
    }

    public EmpReponse(List<Emp> lst, String status) {
        this.lst = lst;
        this.status = status;
    }
}
