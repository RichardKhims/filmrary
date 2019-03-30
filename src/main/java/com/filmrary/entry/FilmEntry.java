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

    private int id;
    private String name;
    private Category category;
    private Date filmedDate;
    private int producerId;
    private ProducerEntry producer;
    private List<Integer> actorsIds;
    private List<ActorEntry> actors;
    private String about;

    public FilmEntry() {

    }

    public FilmEntry(int id, String name, Category category, Date filmedDate, int producerId, List<Integer> actorsIds, String about) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.filmedDate = filmedDate;
        this.producerId = producerId;
        this.actorsIds = actorsIds;
        this.about = about;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public List<Integer> getActorsIds() {
        return actorsIds;
    }

    public void setActorsIds(List<Integer> actorsIds) {
        this.actorsIds = actorsIds;
    }
}
