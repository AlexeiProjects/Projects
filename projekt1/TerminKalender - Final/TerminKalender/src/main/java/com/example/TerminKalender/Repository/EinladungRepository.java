package com.example.TerminKalender.Repository;

import com.example.TerminKalender.Model.Einladung;
import com.example.TerminKalender.Model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EinladungRepository extends JpaRepository<Einladung,Long> {

    List<Einladung> findAllByinvitedId(Long Id);
}
