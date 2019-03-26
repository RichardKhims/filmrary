package com.filmrary.entry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filmrary.Util.DateUtilKt;

import java.util.Date;

abstract public class Person {
    private String name;
    private String photoUrl;
    private Date birthday;
    private String history;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        DateUtilKt.checkDate(birthday, "birthday");
        this.birthday = birthday;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", birthday=" + birthday +
                ", history='" + history + '\'' +
                '}';
    }

    @JsonIgnore
    abstract public Builder getBuilder();

    @JsonIgnoreProperties
    public interface Builder<T extends Person> {
        T setName(String name);
        T setPhotoUrl(String photoUrl);
        T setBirthday(Date birthday);
        T setHistory(String history);
    }
}
