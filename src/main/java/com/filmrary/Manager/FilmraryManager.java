package com.filmrary.Manager;

import com.filmrary.Storage.FileStorage.ActorsFileStorage;
import com.filmrary.Storage.Storage;
import com.filmrary.entry.ActorEntry;
import com.filmrary.entry.FilmEntry;
import com.filmrary.entry.ProducerEntry;
import com.filmrary.exception.ReadWriteException;
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
        } catch (ReadWriteException e) {

        }

        return null;
    }
}
