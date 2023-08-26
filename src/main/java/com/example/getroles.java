package com.example;

import io.agroal.api.AgroalDataSource;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Path("/getroles")
public class getroles {

    @Inject
    AgroalDataSource agroalDataSource;

    @ConfigProperty(name = "SQL.getfirstrole")
    String getfirstrole;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getroles() throws SQLException {
        Connection con = agroalDataSource.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(getfirstrole);
        while (resultSet.next()) {
            return resultSet.getString("role_name");
        }
        return "hello";
    }
}