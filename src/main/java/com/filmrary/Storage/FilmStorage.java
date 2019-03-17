package com.filmrary.Storage;

import com.filmrary.entry.FilmEntry;

import java.util.List;

public interface FilmStorage extends Storage<FilmEntry> {
    FilmEntry getFilmById(int id);
    List<FilmEntry> getFilmsInCategory(FilmEntry.Category category);
}
