package com.example.TerminKalender.Service;

import com.example.TerminKalender.Model.Termin;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SortService {


    //Sortiert Terminen nach Jahr, Monat, Tag und Uhrzeit
    public List<Termin> sortByDate(List<Termin> termine){
        termine.sort(Comparator.comparing(Termin::getJahr)
                .thenComparing(Termin::getMonat)
                .thenComparing(Termin::getTag)
                .thenComparing(Termin::getUhrzeit));


        return termine;

    }
}
