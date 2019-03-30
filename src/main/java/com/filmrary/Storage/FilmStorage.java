package com.filmrary.Storage;

import com.filmrary.entry.FilmEntry;
import com.filmrary.exception.EntryNotFoundException;

import java.util.List;

public interface FilmStorage extends Storage<FilmEntry> {
    FilmEntry getFilmById(int id) throws EntryNotFoundException;
    List<FilmEntry> getFilmsInCategory(FilmEntry.Category category) throws EntryNotFoundException;
}
