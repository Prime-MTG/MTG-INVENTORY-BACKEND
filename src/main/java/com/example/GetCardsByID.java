package com.example;

import io.agroal.api.AgroalDataSource;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Path("/getcardsbyuserid")
public class GetCardsByID {

    @Inject
    AgroalDataSource agroalDataSource;

    @ConfigProperty(name = "SQL.getcardsbyuserid")
    String getcardsbyuserid
            ;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getroles(@QueryParam("id") String id) throws SQLException {
        Connection con = agroalDataSource.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(getcardsbyuserid);
        while (resultSet.next()) {
            return resultSet.getString("CardID");
        }
        return "hello";
    }
}