package com.example.registeruserapi.repository;


import com.example.registeruserapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT h FROM User h where h.email= ?1")
    User findEmail(String email);
}

