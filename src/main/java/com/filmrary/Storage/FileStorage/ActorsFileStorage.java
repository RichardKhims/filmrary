package com.filmrary.Storage.FileStorage;

import com.filmrary.entry.ActorEntry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.filmrary.exception.IncorrectFileException;
import org.apache.commons.lang3.StringUtils;

public class ActorsFileStorage implements FileStorage<ActorEntry> {
    private static final int FIELDS_COUNT = 6;
    private static final int FIELD_ID_INDEX = 0;
    private static final int FIELD_NAME_INDEX = 1;
    private static final int FIELD_PHOTOURL_INDEX = 2;
    private static final int FIELD_BIRTHDAY_INDEX = 3;
    private static final int FIELD_HISTORY_INDEX = 4;
    private static final int FIELD_FILMS_INDEX = 5;
    private static final String DATE_FORMAT = "dd.mm.yyyy";
    private static final String SPLITTER = ";";

    private String fileName;

    ActorsFileStorage(String fileName) {
        setFileName(fileName);
    }

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
                String[] fields = line.split(SPLITTER);
                if (fields.length < FIELDS_COUNT) {
                    throw new IncorrectFileException("Invalid file " + fileName);
                }
                int id = Integer.valueOf(fields[FIELD_ID_INDEX]);
                String name = fields[FIELD_NAME_INDEX];
                String photoUrl = fields[FIELD_PHOTOURL_INDEX];
                Date bithday = Date.from(Instant.parse(fields[FIELD_BIRTHDAY_INDEX]));
                String history = fields[FIELD_HISTORY_INDEX];
                String films = fields[FIELD_FILMS_INDEX];

                ActorEntry actor = new ActorEntry()
                        .getBuilder().setId(id)
                        .getBuilder().setName(name)
                        .getBuilder().setPhotoUrl(photoUrl)
                        .getBuilder().setBirthday(bithday)
                        .getBuilder().setHistory(history)
                        .getBuilder().setPlayedFilmIds(Arrays.asList(films.split(",")));

                result.add(actor);
            } while (StringUtils.isEmpty(line));
            reader.close();
            return result;
        } catch (IncorrectFileException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Read actors fialed");
            return null;
        }
    }

    @Override
    public void saveAll(List<ActorEntry> entries) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));

            for (ActorEntry entry : entries) {
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
                            sb.append(entry.getBirthday()).append(SPLITTER);
                            break;
                        case FIELD_HISTORY_INDEX:
                            sb.append(entry.getHistory()).append(SPLITTER);
                            break;
                        case FIELD_FILMS_INDEX:
                            sb.append(String.join(",", entry.getPlayedFilmIds())).append(SPLITTER);
                            break;
                    }
                }
                sb.append('\n');
                writer.write(sb.toString());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Save actors fialed");
        }
    }
}
