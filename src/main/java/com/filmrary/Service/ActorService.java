package com.filmrary.Service;

import com.filmrary.Storage.ActorStorage;
import com.filmrary.entry.ActorEntry;
import com.filmrary.exception.EntryNotFoundException;
import com.filmrary.exception.ReadWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Configuration
@ImportResource({"classpath*:application-context.xml"})
@RequestMapping("/actors")
public class ActorService {
    @Autowired
    @Qualifier("actorsStorage")
    private ActorStorage actorsStorage;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ActorEntry> getActors() throws ReadWriteException {
            return actorsStorage.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ActorEntry getActorById(@PathVariable Integer id) throws EntryNotFoundException {
        return actorsStorage.getActorById(id);
    }

    @RequestMapping(value = "/byFilmId/{id}", method = RequestMethod.GET)
    List<ActorEntry> getActorsByFilmId(@PathVariable Integer id) throws EntryNotFoundException {
        return actorsStorage.getActorsByFilmId(id);
    }
}
