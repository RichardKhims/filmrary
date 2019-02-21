package com.filmrary.entry;

import com.filmrary.Util.DateUtilKt;

import java.util.Date;
import java.util.List;

public class FilmEntry implements Entry {

    public enum Category {
        ROMANCE,
        SCIENCE,
        HORROR,
        DOCUMENTARY,
        ANIMATION,
        ACTION,
        THRILLER,
        DRAMA,
        COMEDY,
        ADVENTURE
    }

    private Category category;
    private Date filmedDate;
    private ProducerEntry producer;
    private List<ActorEntry> actors;
    private String about;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getFilmedDate() {
        return filmedDate;
    }

    public void setFilmedDate(Date filmedDate) {
        DateUtilKt.checkDate(filmedDate, "filmedDate");
        this.filmedDate = filmedDate;
    }

    public ProducerEntry getProducer() {
        return producer;
    }

    public void setProducer(ProducerEntry producer) {
        this.producer = producer;
    }

    public List<ActorEntry> getActors() {
        return actors;
    }

    public void setActors(List<ActorEntry> actors) {
        this.actors = actors;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
