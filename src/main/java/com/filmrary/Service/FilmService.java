package com.filmrary.Service;

import com.filmrary.Storage.FilmStorage;
import com.filmrary.entry.FilmEntry;
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
@RequestMapping("/films")
public class FilmService {
    @Autowired
    @Qualifier("filmsStorage")
    private FilmStorage filmsStorage;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<FilmEntry> getFilms() throws ReadWriteException {
        return filmsStorage.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    FilmEntry getFilmById(@PathVariable Integer id) throws EntryNotFoundException {
        return filmsStorage.getFilmById(id);
    }

    @RequestMapping(value = "/category/{name}", method = RequestMethod.GET)
    List<FilmEntry> getFilmsInCategory(@PathVariable String name) throws EntryNotFoundException {
        return filmsStorage.getFilmsInCategory(FilmEntry.Category.valueOf(name));
    }
}
