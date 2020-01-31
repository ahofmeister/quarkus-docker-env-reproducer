package org.acme;

import io.quarkus.runtime.configuration.ProfileManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.TreeMap;

@Path("metainfo")
@Produces(MediaType.APPLICATION_JSON)
public class MetaInfoResource {

    @ConfigProperty(name = "quarkus.application.version", defaultValue = "not-set")
    String applicationVersion;

    @ConfigProperty(name = "quarkus.datasource.url")
    String url;

    @ConfigProperty(name = "quarkus.datasource.driver")
    String driver;

    @ConfigProperty(name = "quarkus.datasource.username", defaultValue = "not-set")
    String username;

    @ConfigProperty(name = "quarkus.datasource.password", defaultValue = "not-set")
    String password;

    @ConfigProperty(name = "quarkus.hibernate-orm.database.generation", defaultValue = "not-set")
    String generation;

    @ConfigProperty(name = "quarkus.hibernate-orm.sql-load-script", defaultValue = "not-set")
    String loadSql;

    @GET
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new TreeMap<>();
        properties.put("version", this.applicationVersion);
        properties.put("profile", ProfileManager.getActiveProfile());
        properties.put("quarkus.datasource.url", this.url);
        properties.put("quarkus.datasource.driver", driver);
        properties.put("quarkus.datasource.username", username);
        properties.put("quarkus.hibernate-orm.database.generation", generation);
        properties.put("quarkus.hibernate-orm.sql-load-script", loadSql);
        return properties;
    }

}