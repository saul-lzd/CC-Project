
import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import resources.Resource;

/**
 * This class initialize the HTTP server.
 *
 * @author saulopez
 * @date 28th December, 2018
 */
public class Main {

    private static final int PORT = 8084;
    private static final String HOST = "http://localhost/";

    public static void main(String[] args) {      
        System.out.println("::: Initializing server.");

        URI baseUri = UriBuilder.fromUri(HOST).port(PORT).build();
        
        ResourceConfig config = new ResourceConfig(Resource.class);
//        ResourceConfig config = new ResourceConfig(OSLCResource.class);
        
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
        
        System.out.println("::: Server started.");
    }

}
