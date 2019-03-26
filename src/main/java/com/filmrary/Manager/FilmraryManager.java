package com.filmrary.Manager;

import com.filmrary.Storage.FileStorage.ActorsFileStorage;
import com.filmrary.Storage.Storage;
import com.filmrary.entry.ActorEntry;
import com.filmrary.entry.FilmEntry;
import com.filmrary.entry.ProducerEntry;
import com.filmrary.exception.ReadWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Configuration
@ImportResource({"classpath*:application-context.xml"})
public class FilmraryManager {

    @Autowired
    @Qualifier("actorsStorage")
    private ActorsFileStorage actorsStorage;

    @Autowired
    @Qualifier("filmsStorage")
    private Storage<FilmEntry> filmsStorage;

    @Autowired
    @Qualifier("producersStorage")
    private Storage<ProducerEntry> producersStorage;

    public List<ActorEntry> getActors() {
        try {
            return actorsStorage.readAll();
        } catch (ReadWriteException e) {

        }

        return null;
    }
}
