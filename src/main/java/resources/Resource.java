package resources;

import dao.Query;
import entities.User;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.AbstractResource;

/**
 *
 * @author saulopez
 */
@Path("resources")
public class Resource extends AbstractResource {

    private Response response;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response init() {
        return buildResponse("Services Running", Response.Status.OK);
    }

    @GET
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response get(@PathParam("name") String name) {

        try {
            User user = Query.findUserByName(name);

            if (user == null) {
                response = buildResponse("User not found", Response.Status.BAD_REQUEST);
            } else {
                response = buildResponse(user, Response.Status.OK);
            }
        } catch (SQLException ex) {
                response = buildResponse(ex.getMessage(), Response.Status.BAD_REQUEST);
        }

        return response;
    }            
 

}
