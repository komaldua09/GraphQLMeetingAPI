package com.learning.graphql;

import com.learning.graphql.models.Meeting;
import com.learning.graphql.models.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MeetingApiApplication {
    public static List<Person> persons = new ArrayList<>();

    public static List<Meeting> meetings = new ArrayList<>();


    public static void main(String[] args) {
        SpringApplication.run(MeetingApiApplication.class, args);
    }

}
