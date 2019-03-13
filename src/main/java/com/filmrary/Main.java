package com.filmrary;

import com.filmrary.entry.ActorEntry;
import com.filmrary.entry.ProducerEntry;

public class Main {
    public static void main(String[] args) {
        ActorEntry actor = new ActorEntry();
//        actor.setBirthday(null);

        ProducerEntry producer = new ProducerEntry();
//        producer.setBirthday(null);

        System.out.println(actor);
        System.out.println(producer);
    }
}
