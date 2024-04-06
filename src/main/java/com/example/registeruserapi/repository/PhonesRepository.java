package com.example.registeruserapi.repository;


import com.example.registeruserapi.entity.Phones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<Phones, Long> {
}
