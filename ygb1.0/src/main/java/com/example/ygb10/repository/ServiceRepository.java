package com.example.ygb10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
import com.example.ygb10.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {

}
