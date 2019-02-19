package com.filmrary.entry;

import java.util.List;

public class ProducerEntry extends Person implements Entry {
    private List<FilmEntry> producedFilms;

    public List<FilmEntry> getProducedFilms() {
        return producedFilms;
    }

    public void setProducedFilms(List<FilmEntry> producedFilms) {
        this.producedFilms = producedFilms;
    }
}
