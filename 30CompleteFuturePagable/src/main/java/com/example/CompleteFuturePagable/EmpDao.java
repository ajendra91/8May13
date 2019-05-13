package com.example.CompleteFuturePagable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface EmpDao extends JpaRepository<Emp,Integer> {


    CompletableFuture<Emp> findByName(String name);

    List<Emp> findByName(String name, Pageable pageable);
}


//@RepositoryRestResource(collectionResourceRel = "emp", path = "emp")
//public interface PersonRepository extends PagingAndSortingRepository<Emp, Long> {

    //List<Emp> findByLastName(@Param("name") String name);

//}