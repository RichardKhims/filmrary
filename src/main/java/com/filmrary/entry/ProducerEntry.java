package com.filmrary.entry;

import java.util.Date;
import java.util.List;

public class ProducerEntry extends Person implements Entry {

    private int id;
    private List<Integer> producedFilmsIDs;
    private List<FilmEntry> producedFilms;
    private Builder builder = new Builder();

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

    @Override
    public Person.Builder getBuilder() {
        return builder;
    }

    public class Builder implements Person.Builder<ProducerEntry> {
        @Override
        public ProducerEntry setName(String name) {
            ProducerEntry.this.setName(name);
            return ProducerEntry.this;
        }

        @Override
        public ProducerEntry setPhotoUrl(String photoUrl) {
            ProducerEntry.this.setPhotoUrl(photoUrl);
            return ProducerEntry.this;
        }

        @Override
        public ProducerEntry setHistory(String history) {
            ProducerEntry.this.setHistory(history);
            return ProducerEntry.this;
        }

        @Override
        public ProducerEntry setBirthday(Date birthday) {
            ProducerEntry.this.setBirthday(birthday);
            return ProducerEntry.this;
        }

        public ProducerEntry setProducedFilms(List<FilmEntry> producedFilms) {
            ProducerEntry.this.setProducedFilms(producedFilms);
            return ProducerEntry.this;
        }

        public ProducerEntry setId(int id) {
            ProducerEntry.this.setId(id);
            return ProducerEntry.this;
        }
    }
}
