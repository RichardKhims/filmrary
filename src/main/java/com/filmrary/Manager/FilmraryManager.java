package com.filmrary.Manager;

import com.filmrary.Storage.Storage;
import com.filmrary.entry.ActorEntry;
import com.filmrary.entry.FilmEntry;
import com.filmrary.entry.ProducerEntry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilmraryManager {

    @Autowired
    private Storage<ActorEntry> actorsStorage;

    @Autowired
    private Storage<FilmEntry> filmsStorage;

    @Autowired
    private Storage<ProducerEntry> producersStorage;

    public List<ActorEntry> getActors() {
        try {
            return actorsStorage.readAll();
        } catch (Exception e) {

        }

        return null;
    }
}
