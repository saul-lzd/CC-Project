
package resources;

import java.net.URI;
import java.sql.Date;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;

/**
 *
 * @author saulopez
 */
@Path("resources/oslc")
@OslcNamespace(OslcConstants.OSLC_CORE_NAMESPACE) 
public class OSLCResource extends AbstractResource {
    
//    private URI instanceShape;
//    private URI serviceProvider;
    
    private final Set<URI> contributors = new TreeSet<URI>();
    private final Set<URI> creators = new TreeSet<URI>();
    private final Set<String> dctermsTypes = new TreeSet<String>();
    private final Set<URI> rdfTypes = new TreeSet<URI>();

    private Date created;
    private String description;
    private String identifier;
    private URI source;
    private URI instanceShape;
    private Date modified;
    private URI serviceProvider;
    private String title;
    
    @GET
    @Path("/")
    @Produces(OslcMediaType.APPLICATION_RDF_XML)
    public Response getResource() {
        return Response.status(Status.OK)
                .entity("Alive")
                .encoding("UTF8")
                .build();
    }
    
    
    @GET
    @Path("/get")
    @OslcDescription("Resource Shape that provides hints as to resource property value-types and allowed values. ")
    @OslcPropertyDefinition(OslcConstants.OSLC_CORE_NAMESPACE + "instanceShape")
    @OslcRange(OslcConstants.TYPE_RESOURCE_SHAPE)
    
    @OslcTitle("Instance Shape")
    public URI getInstanceShape() {
        return instanceShape;
    }
    
    
    @OslcDescription("The scope of a resource is a URI for the resource's OSLC Service Provider.")
    @OslcPropertyDefinition(OslcConstants.OSLC_CORE_NAMESPACE + "serviceProvider")
    @OslcRange(OslcConstants.TYPE_SERVICE_PROVIDER)
    @OslcTitle("Service Provider")
    public URI getServiceProvider() {
        return serviceProvider;
    }
    
    
    @OslcDescription("The scope of a resource is a URI for the resource's OSLC Service Provider.")
    @OslcPropertyDefinition(OslcConstants.OSLC_CORE_NAMESPACE + "serviceProviderCatalog")
    @OslcRange(OslcConstants.TYPE_SERVICE_PROVIDER_CATALOG)
    @OslcTitle("Service Provider")
    public URI getServiceProviderCatalog() {
        return serviceProvider;
    }
    
    
    
    
    public void setContributors(final URI[] contributors) {
        this.contributors.clear();

        if (contributors != null) {
            this.contributors.addAll(Arrays.asList(contributors));
        }
    }

    public void setCreated(final Date created) {
        this.created = created;
    }

    public void setCreators(final URI[] creators) {
        this.creators.clear();

        if (creators != null) {
            this.creators.addAll(Arrays.asList(creators));
        }
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }

    public void setInstanceShape(final URI instanceShape) {
        this.instanceShape = instanceShape;
    }

    public void setModified(final Date modified) {
        this.modified = modified;
    }

    public void setRdfTypes(final URI[] rdfTypes) {
        this.rdfTypes.clear();

        if (rdfTypes != null) {
            this.rdfTypes.addAll(Arrays.asList(rdfTypes));
        }
    }

    public void setDctermsTypes(final String[] dctermsTypes) {
        this.dctermsTypes.clear();

        if (dctermsTypes != null) {
            this.dctermsTypes.addAll(Arrays.asList(dctermsTypes));
        }
    }

    public void setSource(final URI source) {
        this.source = source;
    }

    public void setServiceProvider(final URI serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public void setTitle(final String title) {
        this.title = title;
    }




    
    
    
}
