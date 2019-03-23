package com.filmrary.Storage;

import com.filmrary.entry.Entry;
import com.filmrary.exception.ReadWriteException;

import java.util.List;

public interface Storage <T extends Entry> {
    List<T> readAll() throws ReadWriteException;
    void saveAll(List<T> entries);
}
