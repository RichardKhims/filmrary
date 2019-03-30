package com.filmrary.entry;

import java.util.Date;
import java.util.List;

public class ActorEntry extends Person implements Entry {
    private int id;
    private List<Integer> playedFilmIds;
    private List<FilmEntry> playedFilms;

    public ActorEntry() {

    }

    public ActorEntry(int id, String name, String photoUrl, Date birthday, String history, List<Integer> playedFilmIds) {
        super(name, photoUrl, birthday, history);
        this.id = id;
        this.playedFilmIds = playedFilmIds;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getPlayedFilmIds() {
        return playedFilmIds;
    }

    public void setPlayedFilmIds(List<Integer> playedFilmIds) {
        this.playedFilmIds = playedFilmIds;
    }

    public List<FilmEntry> getPlayedFilms() {
        return playedFilms;
    }

    public void setPlayedFilms(List<FilmEntry> playedFilms) {
        this.playedFilms = playedFilms;
    }
}
