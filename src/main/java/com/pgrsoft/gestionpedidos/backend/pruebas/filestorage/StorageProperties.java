package com.pgrsoft.gestionpedidos.backend.pruebas.filestorage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     * 
     * Se tendría que buscar de un fichero de properties y no hardcoded!
     * 
     */
    private String location = "C:\\imagenes";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }	
	
}
