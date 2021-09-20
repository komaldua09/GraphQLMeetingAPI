package com.learning.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.learning.graphql.MeetingApiApplication;
import com.learning.graphql.models.Agenda;
import com.learning.graphql.models.Meeting;
import com.learning.graphql.models.Person;
import com.learning.graphql.models.input.AgendaInput;
import com.learning.graphql.models.input.MeetingInput;
import com.learning.graphql.models.input.PersonInput;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Mutation implements GraphQLMutationResolver {

    public Meeting createMeeting(MeetingInput meetingInput){

        Meeting meeting = new Meeting();
        meeting.setId(UUID.randomUUID().toString());
        meeting.setStartsAt(meetingInput.getStartsAt());
        meeting.setEndsAt(meetingInput.getEndsAt());
        var organizer = MeetingApiApplication.persons.stream().filter(person -> person.getId().equalsIgnoreCase(meetingInput.getOrganizerID())).findFirst().get();
        meeting.setOrganizer(organizer);
        List<Person> invitees = new ArrayList<>();
        for (String inviteeId: meetingInput.getInvitees()) {
            var invitee = MeetingApiApplication.persons.stream().filter(person -> person.getId().equalsIgnoreCase(inviteeId)).findFirst().get();
            invitees.add(invitee);
        }
        meeting.setInvitees(invitees);
        var agendas = new ArrayList<Agenda>();
        for(AgendaInput agendaInput : meetingInput.getAgendas()) {
            Agenda agenda = new Agenda();
            agenda.setId(UUID.randomUUID().toString());
            agenda.setDescription(agendaInput.getDescription());
            agenda.setTitle(agendaInput.getTitle());
            agendas.add(agenda);
        }
        meeting.setAgendas(agendas);
        MeetingApiApplication.meetings.add(meeting);
        return meeting;
    }

    public Person createPerson(PersonInput personInput){

        Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setEmail(personInput.getEmail());
        person.setFirstName(personInput.getFirstName());
        person.setLastName(personInput.getLastName());
        if(StringUtils.isNotBlank(personInput.getPhoneNumber()))
            person.setPhoneNumber(personInput.getPhoneNumber());

        MeetingApiApplication.persons.add(person);

        return person;
    }

}
