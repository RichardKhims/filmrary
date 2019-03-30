package com.filmrary.Manager;

import com.filmrary.Storage.ActorStorage;
import com.filmrary.Storage.FilmStorage;
import com.filmrary.Storage.ProducerStorage;
import com.filmrary.entry.ActorEntry;
import com.filmrary.exception.ReadWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

@Configuration
@ImportResource({"classpath*:application-context.xml"})
public class FilmraryManager {

    @Autowired
    @Qualifier("actorsStorage")
    private ActorStorage actorsStorage;

    @Autowired
    @Qualifier("filmsStorage")
    private FilmStorage filmsStorage;

    @Autowired
    @Qualifier("producersStorage")
    private ProducerStorage producersStorage;

    public List<ActorEntry> getActors() {
        try {
            return actorsStorage.readAll();
        } catch (ReadWriteException e) {

        }

        return null;
    }
}
