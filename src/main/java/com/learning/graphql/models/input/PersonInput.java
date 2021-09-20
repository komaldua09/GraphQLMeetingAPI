package com.learning.graphql.models.input;

import lombok.Data;

@Data
public class PersonInput {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

}
