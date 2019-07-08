package com.nttdata.practicadevara.projapp.rest.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class ProjappRestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        // register root resource
        classes.add(ServicesEmployee.class);
        classes.add(ServicesTechnology.class);
        
        
        return classes;
    }
   
}
