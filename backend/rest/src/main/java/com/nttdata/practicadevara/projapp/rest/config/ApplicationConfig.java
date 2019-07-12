package com.nttdata.practicadevara.projapp.rest.config;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
        try {
            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.nttdata.practicadevara.projapp.rest.services.ServicesAppRolesTechnologies.class);
        resources.add(com.nttdata.practicadevara.projapp.rest.services.ServicesApplication.class);
        resources.add(com.nttdata.practicadevara.projapp.rest.services.ServicesEmpTech.class);
        resources.add(com.nttdata.practicadevara.projapp.rest.services.ServicesEmployee.class);
        resources.add(com.nttdata.practicadevara.projapp.rest.services.ServicesLevel.class);
        resources.add(com.nttdata.practicadevara.projapp.rest.services.ServicesRole.class);
        resources.add(com.nttdata.practicadevara.projapp.rest.services.ServicesTechnology.class);
    }

}
