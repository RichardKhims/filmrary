package com.filmrary.Storage.FileStorage;

import com.filmrary.Storage.ActorStorage;
import com.filmrary.entry.ActorEntry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.filmrary.exception.IncorrectFileException;
import org.apache.commons.lang3.StringUtils;

public class ActorsFileStorage implements ActorStorage, FileStorage<ActorEntry> {
    private static final int FIELDS_COUNT = 6;
    private static final int FIELD_ID_INDEX = 0;
    private static final int FIELD_NAME_INDEX = 1;
    private static final int FIELD_PHOTOURL_INDEX = 2;
    private static final int FIELD_BIRTHDAY_INDEX = 3;
    private static final int FIELD_HISTORY_INDEX = 4;
    private static final int FIELD_FILMS_INDEX = 5;
    private static final String DATE_FORMAT = "dd.mm.yyyy";
    private static final String SPLITTER = ";";

    private DateFormat df = new SimpleDateFormat(DATE_FORMAT);

    private String fileName;

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public List<ActorEntry> readAll() throws IncorrectFileException {
        List<ActorEntry> result = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            do {
                line = reader.readLine();
                ActorEntry actor = parseLine(line);
                result.add(actor);
            } while (StringUtils.isEmpty(line));
            reader.close();
            return result;
        } catch (IncorrectFileException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Read actors failed: " + e);
            return null;
        }
    }

    @Override
    public void saveAll(List<ActorEntry> entries) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));

            for (ActorEntry entry : entries) {
                writer.write(makeLine(entry));
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Save actors failed: " + e);
        }
    }

    @Override
    public ActorEntry getActorById(int id) {
        try {
            return readAll().stream().filter(entry -> entry.getId() == id).findFirst().orElse(null);
        } catch (IncorrectFileException e) {
            System.out.println("Failed to find actor: " + e);
        }

        return null;
    }

    @Override
    public List<ActorEntry> getActorsByFilmId(int filmId) {
        try {
            return readAll().stream().filter(entry -> entry.getPlayedFilmIds().contains(filmId)).collect(Collectors.toList());
        } catch (IncorrectFileException e) {
            System.out.println("Failed to find film: " + e);
        }

        return null;
    }

    private ActorEntry parseLine(String line) throws IncorrectFileException, ParseException {
        String[] fields = line.split(SPLITTER);
        if (fields.length < FIELDS_COUNT) {
            throw new IncorrectFileException("Invalid file " + fileName);
        }
        int id = Integer.valueOf(fields[FIELD_ID_INDEX]);
        String name = fields[FIELD_NAME_INDEX];
        String photoUrl = fields[FIELD_PHOTOURL_INDEX];
        Date birthday = df.parse(fields[FIELD_BIRTHDAY_INDEX]);
        String history = fields[FIELD_HISTORY_INDEX];
        String films = fields[FIELD_FILMS_INDEX];
        List<Integer> filmsIds = Arrays.stream(films.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        return new ActorEntry(id, name, photoUrl, birthday, history, filmsIds);
    }

    private String makeLine(ActorEntry entry) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < FIELDS_COUNT; i++) {
            switch (i) {
                case FIELD_ID_INDEX:
                    sb.append(entry.getId()).append(SPLITTER);
                    break;
                case FIELD_NAME_INDEX:
                    sb.append(entry.getName()).append(SPLITTER);
                    break;
                case FIELD_PHOTOURL_INDEX:
                    sb.append(entry.getPhotoUrl()).append(SPLITTER);
                    break;
                case FIELD_BIRTHDAY_INDEX:
                    sb.append(df.format(entry.getBirthday())).append(SPLITTER);
                    break;
                case FIELD_HISTORY_INDEX:
                    sb.append(entry.getHistory()).append(SPLITTER);
                    break;
                case FIELD_FILMS_INDEX:
                    sb.append(entry.getPlayedFilmIds().stream().map(String::valueOf).collect(Collectors.joining(","))).append(SPLITTER);
                    break;
            }
        }
        sb.append('\n');

        return sb.toString();
    }
}
