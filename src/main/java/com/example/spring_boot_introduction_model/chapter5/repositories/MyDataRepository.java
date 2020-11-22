package com.example.spring_boot_introduction_model.chapter5.repositories;

import com.example.spring_boot_introduction_model.chapter5.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
