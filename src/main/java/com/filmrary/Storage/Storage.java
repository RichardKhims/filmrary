package com.filmrary.Storage;

import com.filmrary.entry.Entry;
import com.filmrary.exception.IncorrectFileException;

import java.util.List;

public interface Storage <T extends Entry> {
    List<T> readAll() throws IncorrectFileException;
    void saveAll(List<T> entries);
}
