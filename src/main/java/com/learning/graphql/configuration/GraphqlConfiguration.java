package com.learning.graphql.configuration;

import com.learning.graphql.resolvers.Mutation;
import com.learning.graphql.resolvers.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public Query query() {
        return new Query();
    }

    @Bean
    public Mutation mutation() {
        return new Mutation();
    }

}
