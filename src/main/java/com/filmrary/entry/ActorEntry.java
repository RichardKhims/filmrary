package com.filmrary.entry;

import java.util.List;

public class ActorEntry extends Person implements Entry {
    private List<FilmEntry> playedFilms;

    public List<FilmEntry> getPlayedFilms() {
        return playedFilms;
    }

    public void setPlayedFilms(List<FilmEntry> playedFilms) {
        this.playedFilms = playedFilms;
    }
}
