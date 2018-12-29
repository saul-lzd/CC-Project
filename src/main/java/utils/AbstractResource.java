package utils;

import com.google.gson.Gson;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author saulopez
 * @date 28th December, 2018
 */
public abstract class AbstractResource extends ResourceConfig{

    /**
     * This method build a custom response based on the parameters given.
     *
     * @param entity The element to return to client
     * @param status The status of the response to return to client.
     * @return Response
     */
    public Response buildResponse(Object entity, Response.Status status) {
        return Response.status(status)
                .entity(entity)
                .encoding("UTF8")
                .build();
    }

    /**
     * This method wraps the method toJson() from Gson library in order to get a
     * cleaner implementation.
     *
     * @param object
     * @return the json in String representation.
     */
    protected static String toJSON(Object object) {
        return new Gson().toJson(object);
    }

    /**
     *
     * @param message
     * @return The passed message as argument as a Json representation.
     */
    protected static String writeMessage(String message) {
        return "{ \"message\" : \"" + message + "\"}";
    }
    
    protected static String MESSAGE_SUCCESS() {
        return writeMessage("SUCCESS");
    }

}
