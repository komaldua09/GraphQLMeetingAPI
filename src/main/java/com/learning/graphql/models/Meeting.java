package com.learning.graphql.models;

import lombok.Data;
import java.util.List;

@Data
public class Meeting {

    private String id;

    private long startsAt;

    private long endsAt;

    private Person organizer;

    private List<Person> invitees;

    private List<Agenda> agendas;

}