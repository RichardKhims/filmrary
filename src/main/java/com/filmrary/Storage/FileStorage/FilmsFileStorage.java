package com.filmrary.Storage.FileStorage;

import com.filmrary.Storage.FilmStorage;
import com.filmrary.entry.FilmEntry;
import com.filmrary.exception.IncorrectFileException;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FilmsFileStorage implements FilmStorage, FileStorage<FilmEntry> {

    private static final int FIELDS_COUNT = 7;
    private static final int FIELD_ID_INDEX = 0;
    private static final int FIELD_NAME_INDEX = 1;
    private static final int FIELD_CATEGORY_INDEX = 2;
    private static final int FIELD_DATE_INDEX = 3;
    private static final int FIELD_PRODUCER_INDEX = 4;
    private static final int FIELD_ACTORS_INDEX = 5;
    private static final int FIELD_ABOUT_INDEX = 6;

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
    public List<FilmEntry> readAll() throws IncorrectFileException {
        List<FilmEntry> result = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            do {
                line = reader.readLine();
                FilmEntry film = parseLine(line);
                result.add(film);
            } while (StringUtils.isEmpty(line));
            reader.close();
            return result;
        } catch (IncorrectFileException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("Read films failed: " + e);
            return null;
        }
    }

    @Override
    public void saveAll(List<FilmEntry> entries) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));

            for (FilmEntry entry : entries) {
                writer.write(makeLine(entry));
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Save actors failed: " + e);
        }
    }

    @Override
    public FilmEntry getFilmById(int id) {
        try {
            return readAll().stream().filter(entry -> entry.getId() == id).findFirst().orElse(null);
        } catch (IncorrectFileException e) {
            System.out.println("Failed to find film: " + e);
        }

        return null;
    }

    @Override
    public List<FilmEntry> getFilmsInCategory(FilmEntry.Category category) {
        try {
            return readAll().stream().filter(entry -> entry.getCategory().equals(category)).collect(Collectors.toList());
        } catch (IncorrectFileException e) {
            System.out.println("Failed to find film: " + e);
        }

        return null;
    }

    private FilmEntry parseLine(String line) throws IncorrectFileException, ParseException {
        String[] fields = line.split(SPLITTER);
        if (fields.length < FIELDS_COUNT) {
            throw new IncorrectFileException("Invalid file " + fileName);
        }
        int id = Integer.valueOf(fields[FIELD_ID_INDEX]);
        String name = fields[FIELD_NAME_INDEX];
        FilmEntry.Category category = FilmEntry.Category.valueOf(fields[FIELD_CATEGORY_INDEX]);
        Date date = df.parse(fields[FIELD_DATE_INDEX]);
        int producerId = Integer.valueOf(fields[FIELD_PRODUCER_INDEX]);
        String actorsIdsLine = fields[FIELD_ACTORS_INDEX];
        List<Integer> actorsIds = Arrays.stream(actorsIdsLine.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        String about = fields[FIELD_ABOUT_INDEX];

        return new FilmEntry(id, name, category, date, producerId, actorsIds, about);
    }

    private String makeLine(FilmEntry entry) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < FIELDS_COUNT; i++) {
            switch (i) {
                case FIELD_ID_INDEX:
                    sb.append(entry.getId()).append(SPLITTER);
                    break;
                case FIELD_NAME_INDEX:
                    sb.append(entry.getName()).append(SPLITTER);
                    break;
                case FIELD_CATEGORY_INDEX:
                    sb.append(entry.getCategory()).append(SPLITTER);
                    break;
                case FIELD_DATE_INDEX:
                    sb.append(df.format(entry.getFilmedDate())).append(SPLITTER);
                    break;
                case FIELD_PRODUCER_INDEX:
                    sb.append(entry.getProducerId()).append(SPLITTER);
                    break;
                case FIELD_ACTORS_INDEX:
                    sb.append(entry.getActorsIds().stream().map(String::valueOf).collect(Collectors.joining(","))).append(SPLITTER);
                    break;
                case FIELD_ABOUT_INDEX:
                    sb.append(entry.getAbout()).append(SPLITTER);
                    break;
            }
        }
        sb.append('\n');

        return sb.toString();
    }
}
