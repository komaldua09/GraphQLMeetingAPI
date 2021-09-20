package com.learning.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.learning.graphql.MeetingApiApplication;
import com.learning.graphql.models.Meeting;
import com.learning.graphql.models.Person;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Query implements GraphQLQueryResolver {


    public List<Meeting> getMeetings(String id){
        if(StringUtils.isBlank(id)){
            return MeetingApiApplication.meetings;
        }
        else{
            return MeetingApiApplication.meetings
                    .stream()
                    .filter(meeting -> meeting.getId().equalsIgnoreCase(id))
                    .collect(Collectors.toList());
        }
    }


    public List<Person> getPersons(String id){
        if(StringUtils.isBlank(id)){
            return MeetingApiApplication.persons;
        }
        else{
            return MeetingApiApplication.persons
                    .stream()
                    .filter(person -> person.getId().equalsIgnoreCase(id))
                    .collect(Collectors.toList());
        }
    }
}