package com.filmrary.Storage.FileStorage;

import com.filmrary.Storage.Storage;
import com.filmrary.entry.Entry;

public interface FileStorage<T extends Entry> extends Storage<T> {
    void setFileName(String fileName);
    String getFileName();
}
