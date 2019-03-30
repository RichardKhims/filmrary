package com.filmrary.Storage.FileStorage;

import com.filmrary.Storage.ProducerStorage;
import com.filmrary.entry.ProducerEntry;
import com.filmrary.exception.EntryNotFoundException;
import com.filmrary.exception.IncorrectFileException;
import org.apache.commons.lang3.StringUtils;

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

public class ProducersFileStorage implements ProducerStorage, FileStorage<ProducerEntry> {
    private String filename;

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

    @Override
    public void setFileName(String fileName) {
        this.filename = fileName;
    }

    @Override
    public String getFileName() {
        return filename;
    }

    @Override
    public List<ProducerEntry> readAll() throws IncorrectFileException {
        List<ProducerEntry> result = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            do {
                line = reader.readLine();
                ProducerEntry producer = parseLine(line);
                result.add(producer);
            } while (StringUtils.isEmpty(line));
            reader.close();
            return result;
        } catch (IncorrectFileException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Read producers failed: " + e);
            return null;
        }
    }

    @Override
    public void saveAll(List<ProducerEntry> entries) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(filename));

            for (ProducerEntry entry : entries) {
                writer.write(makeLine(entry));
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Save producers failed: " + e);
        }
    }

    @Override
    public ProducerEntry getProducerById(int id) throws EntryNotFoundException {
        try {
            return readAll().stream().filter(entry -> entry.getId() == id).findFirst().orElse(null);
        } catch (IncorrectFileException e) {
            System.out.println("Failed to find producer: " + e);
            throw new EntryNotFoundException("Producer with id:" + Integer.toString(id) + " not found");
        }
    }

    @Override
    public ProducerEntry getProducerByFilmId(int filmId) throws EntryNotFoundException {
        try {
            return readAll().stream().filter(entry -> entry.getProducedFilmsIDs().contains(filmId)).findFirst().orElse(null);
        } catch (IncorrectFileException e) {
            System.out.println("Failed to find producer: " + e);
            throw new EntryNotFoundException("Film with film id:" + Integer.toString(filmId) + " not found");
        }
    }

    private ProducerEntry parseLine(String line) throws IncorrectFileException, ParseException {
        String[] fields = line.split(SPLITTER);
        if (fields.length < FIELDS_COUNT) {
            throw new IncorrectFileException("Invalid file " + filename);
        }
        int id = Integer.valueOf(fields[FIELD_ID_INDEX]);
        String name = fields[FIELD_NAME_INDEX];
        String photoUrl = fields[FIELD_PHOTOURL_INDEX];
        Date birthday = df.parse(fields[FIELD_BIRTHDAY_INDEX]);
        String history = fields[FIELD_HISTORY_INDEX];
        String films = fields[FIELD_FILMS_INDEX];
        List<Integer> filmsIds = Arrays.stream(films.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        return new ProducerEntry(id, name, photoUrl, birthday, history, filmsIds);
    }

    private String makeLine(ProducerEntry entry) {
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
                    sb.append(entry.getProducedFilmsIDs().stream().map(String::valueOf).collect(Collectors.joining(","))).append(SPLITTER);
                    break;
            }
        }
        sb.append('\n');

        return sb.toString();
    }
}
