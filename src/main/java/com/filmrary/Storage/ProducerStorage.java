package com.filmrary.Storage;

import com.filmrary.entry.ProducerEntry;


public interface ProducerStorage extends Storage<ProducerEntry> {
    ProducerEntry getProducerById(int id);
    ProducerEntry getProducerByFilmId(int filmId);
}
