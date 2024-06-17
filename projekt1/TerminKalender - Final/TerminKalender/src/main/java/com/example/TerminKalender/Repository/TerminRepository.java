package com.example.TerminKalender.Repository;

import com.example.TerminKalender.Model.Termin;
import com.example.TerminKalender.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TerminRepository extends JpaRepository<Termin, Long> {
    List<Termin> findAllByerstellerId(Long Id);
}
