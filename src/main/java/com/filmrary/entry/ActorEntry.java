package com.filmrary.entry;

import java.util.Date;
import java.util.List;

public class ActorEntry extends Person implements Entry {
    private int id;
    private List<String> playedFilmIds;
    private List<FilmEntry> playedFilms;
    private Builder builder = new Builder();

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Builder getBuilder() {
        return builder;
    }

    public List<String> getPlayedFilmIds() {
        return playedFilmIds;
    }

    public void setPlayedFilmIds(List<String> playedFilmIds) {
        this.playedFilmIds = playedFilmIds;
    }

    public List<FilmEntry> getPlayedFilms() {
        return playedFilms;
    }

    public void setPlayedFilms(List<FilmEntry> playedFilms) {
        this.playedFilms = playedFilms;
    }

    public class Builder implements Person.Builder<ActorEntry> {
        public ActorEntry setId(int id) {
            ActorEntry.this.setId(id);
            return ActorEntry.this;
        }

        public ActorEntry setPlayedFilmIds(List<String> playedFilmIds) {
            ActorEntry.this.setPlayedFilmIds(playedFilmIds);
            return ActorEntry.this;
        }

        public ActorEntry setPlayedFilms(List<FilmEntry> playedFilms) {
            ActorEntry.this.setPlayedFilms(playedFilms);
            return ActorEntry.this;
        }

        @Override
        public ActorEntry setBirthday(Date birthday) {
            ActorEntry.this.setBirthday(birthday);
            return ActorEntry.this;
        }

        @Override
        public ActorEntry setHistory(String history) {
            ActorEntry.this.setHistory(history);
            return ActorEntry.this;
        }

        @Override
        public ActorEntry setName(String name) {
            ActorEntry.this.setName(name);
            return ActorEntry.this;
        }

        @Override
        public ActorEntry setPhotoUrl(String photoUrl) {
            ActorEntry.this.setPhotoUrl(photoUrl);
            return ActorEntry.this;
        }
    }
}
