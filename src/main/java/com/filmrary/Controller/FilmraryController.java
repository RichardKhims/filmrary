package com.filmrary.Controller;

import com.filmrary.Manager.FilmraryManager;
import com.filmrary.entry.ActorEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmraryController {

    @Autowired
    FilmraryManager manager;

    @RequestMapping("/actors")
    public List<ActorEntry> getActors() {
        return manager.getActors();
    }
}
