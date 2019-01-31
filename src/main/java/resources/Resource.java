package resources;

import dao.UserDAO;
import entities.User;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    @Path("/user/")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response findAll() {

        try {
            List<User> users = UserDAO.findAll();

            if (users.isEmpty()) {
                response = buildResponse("There are no users", Response.Status.BAD_REQUEST);
            } else {
                response = buildResponse(users, Response.Status.OK);
            }
        } catch (SQLException ex) {
            response = buildResponse(ex.getMessage(), Response.Status.BAD_REQUEST);
        }

        return response;
    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getUserById(@PathParam("id") String id) {

        try {
            User user = UserDAO.findById(Integer.parseInt(id));

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

    @POST
    @Path("/user/")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response insertUser(User user) {

        try {
            
            UserDAO.insert(user);

            if (user == null) {
                response = buildResponse("User not found", Response.Status.BAD_REQUEST);
            } else {
                response = buildResponse(user, Response.Status.CREATED);
            }
        } catch (SQLException ex) {
            response = buildResponse(ex.getMessage(), Response.Status.BAD_REQUEST);
        }

        return response;
    }

    @PUT
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response updatetUser(@PathParam("id") String id, User user) {

        try {
            
            UserDAO.update(id, user);

            if (user == null) {
                response = buildResponse("User not found", Response.Status.BAD_REQUEST);
            } else {
                response = buildResponse(user, Response.Status.CREATED);
            }
        } catch (SQLException ex) {
            response = buildResponse(ex.getMessage(), Response.Status.BAD_REQUEST);
        }

        return response;
    }

    @DELETE
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response deleteUser(@PathParam("id") String id) {

        try {
            
            UserDAO.deleteById(id);
            response = buildResponse("User deleted", Response.Status.NO_CONTENT);

        } catch (SQLException ex) {
            response = buildResponse(ex.getMessage(), Response.Status.BAD_REQUEST);
        }

        return response;
    }

}
