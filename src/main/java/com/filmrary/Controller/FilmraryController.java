package com.filmrary.Controller;

import com.filmrary.Manager.FilmraryManager;
import com.filmrary.entry.ActorEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Configuration
@ImportResource({"classpath*:application-context.xml"})
public class FilmraryController {

    @Autowired
    @Qualifier("manager")
    FilmraryManager manager;

    @RequestMapping("/actors")
    public List<ActorEntry> getActors() {
        return manager.getActors();
    }
}
