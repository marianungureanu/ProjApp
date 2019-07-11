package com.nttdata.practicadevara.projapp.shared.dto;

public enum SubscriptionStatusEnumDto {
    NULL(""), NEW("new"), ACCEPTED("accepted"), REJECTED("rejected");
    
    String value;
    
    SubscriptionStatusEnumDto(String v){
        this.value = v;
    }
    
    public String value(){
        return value;
    }
}
