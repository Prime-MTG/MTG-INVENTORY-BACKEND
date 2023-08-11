package com.example;

import io.agroal.api.AgroalDataSource;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Path("/hello")
public class ExampleResource {
//COMMENT
    @Inject
    AgroalDataSource agroalDataSource;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws SQLException {
        Connection con = agroalDataSource.getConnection();
        Statement statement = con.createStatement();
        statement.execute("INSERT INTO roles(role_id, role_name) VALUES (2, 'Bill');");

        return "Hello from RESTEasy Reactive";
    }
}
