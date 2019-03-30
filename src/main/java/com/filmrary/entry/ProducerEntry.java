package com.filmrary.entry;

import java.util.Date;
import java.util.List;

public class ProducerEntry extends Person implements Entry {

    private int id;
    private List<Integer> producedFilmsIDs;
    private List<FilmEntry> producedFilms;

    public ProducerEntry() {

    }

    public ProducerEntry(int id, String name, String photoUrl, Date birthday, String history, List<Integer> producedFilmsIDs) {
        super(name, photoUrl, birthday, history);
        this.id = id;
        this.producedFilmsIDs = producedFilmsIDs;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getProducedFilmsIDs() {
        return producedFilmsIDs;
    }

    public void setProducedFilmsIDs(List<Integer> producedFilmsIDs) {
        this.producedFilmsIDs = producedFilmsIDs;
    }

    public List<FilmEntry> getProducedFilms() {
        return producedFilms;
    }

    public void setProducedFilms(List<FilmEntry> producedFilms) {
        this.producedFilms = producedFilms;
    }
}
