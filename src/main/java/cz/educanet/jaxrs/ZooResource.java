package cz.educanet.jaxrs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;


@Produces(MediaType.APPLICATION_JSON)
@Path("zoo")

public class ZooResource {

    @Inject
    private ZooManager manager;

    @GET
    public Response getAll() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/zoo", "root", "");

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT DISTINCT Z.jmeno, D.nazev FROM Zvirata Z JOIN Druhy D ON D.id = Z.druh");


        while(result.next()) {
            Animal animal = new Animal();
            String jmeno = result.getString("jmeno");
            animal.setName(jmeno);
            String type = result.getString("type");
            animal.getType(type);
            System.out.println(jmeno + "\t" + type + "\t");


        }

        connection.close();
        return Response.ok(manager.getAnimal()).build();
    }
}

