package com.nttdata.practicadevara.scoder.shared.dto;

import java.io.Serializable;

public class AppConfigDto implements Serializable{
    private static final long serialVersionUID = 1001;
    
    private Long id;
    private String key;
    private String value;

    public AppConfigDto() {
    }

    public AppConfigDto(Long id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    

}
