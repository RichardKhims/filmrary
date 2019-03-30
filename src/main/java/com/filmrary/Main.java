package com.filmrary;

import com.filmrary.Storage.FileStorage.ActorsFileStorage;
import com.filmrary.entry.ActorEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ActorEntry actor = new ActorEntry(
                1,
                "Сильвестр Сталлоне",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Sylvester_Stallone.jpg/440px-Sylvester_Stallone.jpg",
                Date.from(Instant.parse("1946-07-06T00:00:00.00Z")),
                "В 15 лет Сталлоне, первоначально оставленный после развода родителей, переехал к матери и стал учиться в специальной школе для трудных подростков. " +
                        "Затем актёр отправился на учёбу в Швейцарию в Американский колледж, подрабатывая при этом тренером и продолжая играть в театре. " +
                        "Вернувшись в Штаты и уже твердо решив стать актёром, Слай пошёл изучать драматическое искусство в Университет в Майами. " +
                        "Закончив учёбу на актёрском факультете, вернулся в Нью-Йорк и играл в небольших театральных постановках. " +
                        "Сталлоне удалось сыграть в нескольких фильмах и двух телесериалах, после чего последовала картина «Рокки» (1976), к которой он написал сценарий и продал его с условием своего участия в главной роли. " +
                        "У Сталлоне по две номинации на премии «Оскар», «Золотой глобус» и BAFTA за «Рокки». " +
                        "Продолжения «Рокки» закрепили его успех и популярность, при том, что он участвовал в написании сценариев всех 8 частей. После 3 части «Рокки», " +
                        "Сталлоне приступил к сюжету «Рэмбо», по одноименной книге Дэвида Морелла, где его роль Рэмбо тоже была немаловажной. " +
                        "Его 3 части тоже имели успех, однако не такой, как «Рокки». К примеру, вторая часть получила «Золотую малину», за худший сюжет, худший актёр, худший противник и худший фильм года. " +
                        "После таких фильмов, как «Рэмбо 3» и «Рокки 4», Сильвестр начал сниматься в менее успешных фильмах, таких как «Кобра», «Взаперти», «Стой! Или моя мама будет стрелять». Но фильмы «Разрушитель» и «Специалист» вернули его к славе.",
                Arrays.asList(1,2,3));

        ActorsFileStorage actorsFileStorage = new ActorsFileStorage();
        actorsFileStorage.setFileName("E:\\Work\\IdeaProjects\\filmrary\\src\\main\\resources\\actors.txt");
        actorsFileStorage.saveAll(Arrays.asList(actor));


        SpringApplication.run(Main.class, args);
    }
}
