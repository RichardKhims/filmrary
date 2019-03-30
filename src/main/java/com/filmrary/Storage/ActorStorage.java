package com.filmrary.Storage;

import com.filmrary.entry.ActorEntry;
import com.filmrary.exception.EntryNotFoundException;

import java.util.List;

public interface ActorStorage extends Storage<ActorEntry> {
    ActorEntry getActorById(int id) throws EntryNotFoundException;
    List<ActorEntry> getActorsByFilmId(int filmId) throws EntryNotFoundException;
}
