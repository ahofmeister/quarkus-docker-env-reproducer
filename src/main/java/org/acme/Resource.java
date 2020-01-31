package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class Resource {

    @ConfigProperty(name = "hello", defaultValue = "world")
    String hello;

    @GET
    @Path("hello")
    @Transactional
    public String get(){
        MyEntity myEntity = new MyEntity();
        myEntity.persist();
        return hello;
    }

}
