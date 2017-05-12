package com.mk.hsbc.hstoneage.jaxrs;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Marcin Kolodziejczyk
 */
@javax.ws.rs.ApplicationPath("jaxrs")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(com.mk.hsbc.hstoneage.jaxrs.MessagesVFacadeREST.class);
        return resources;
    }

}
