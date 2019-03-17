package com.filmrary.Storage;

import com.filmrary.entry.ActorEntry;

import java.util.List;

public interface ActorStorage extends Storage<ActorEntry> {
    ActorEntry getActorById(int id);
    List<ActorEntry> getActorsByFilmId(int filmId);
}
