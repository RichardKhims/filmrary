package com.filmrary.Storage;

import com.filmrary.entry.ProducerEntry;
import com.filmrary.exception.EntryNotFoundException;


public interface ProducerStorage extends Storage<ProducerEntry> {
    ProducerEntry getProducerById(int id) throws EntryNotFoundException;
    ProducerEntry getProducerByFilmId(int filmId) throws EntryNotFoundException;
}
