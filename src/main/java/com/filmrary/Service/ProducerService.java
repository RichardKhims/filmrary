package com.filmrary.Service;

import com.filmrary.Storage.ProducerStorage;
import com.filmrary.entry.ProducerEntry;
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
@RequestMapping("/producers")
public class ProducerService {
    @Autowired
    @Qualifier("producersStorage")
    private ProducerStorage producersStorage;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ProducerEntry> getActors() throws ReadWriteException {
        return producersStorage.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ProducerEntry getProducerById(@PathVariable Integer id) throws EntryNotFoundException {
        return producersStorage.getProducerById(id);
    }

    @RequestMapping(value = "/byFilmId/{id}", method = RequestMethod.GET)
    ProducerEntry getProducerByFilmId(@PathVariable Integer id) throws EntryNotFoundException {
        return producersStorage.getProducerByFilmId(id);
    }
}
