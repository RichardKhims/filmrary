package com.filmrary.entry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

public class ProducerEntry extends Person implements Entry {

    private int id;
    private List<Integer> producedFilmsIDs;
    private List<FilmEntry> producedFilms;

    @JsonIgnore
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

    public Builder getBuilder() {
        return builder;
    }

    @JsonIgnoreProperties
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

        public ProducerEntry setProducedFilmsIds(List<Integer> producedFilms) {
            ProducerEntry.this.setProducedFilmsIDs(producedFilms);
            return ProducerEntry.this;
        }

        public ProducerEntry setId(int id) {
            ProducerEntry.this.setId(id);
            return ProducerEntry.this;
        }
    }
}
