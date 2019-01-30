
import dao.Derby;
import java.net.URI;
import java.sql.SQLException;
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
        try {
            startHttpServer();
            startDerbyDB();
            System.out.println(":::CityCorp Project ready:::");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void startHttpServer() {
        System.out.println("Initializing HTTP server...");
        URI baseUri = UriBuilder.fromUri(HOST).port(PORT).build();
        ResourceConfig config = new ResourceConfig(Resource.class); // OSLCResource        
        JdkHttpServerFactory.createHttpServer(baseUri, config);
        System.out.println("Server started!");
    }

    private static void startDerbyDB() throws SQLException {
        System.out.println("Initializing Derby...");
        Derby.init();
        System.out.println("Derby is running!");
    }
}
