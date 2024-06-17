package com.example.TerminKalender.Repository;

import com.example.TerminKalender.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByName(String name);
    User findNameById(Long id);
}


