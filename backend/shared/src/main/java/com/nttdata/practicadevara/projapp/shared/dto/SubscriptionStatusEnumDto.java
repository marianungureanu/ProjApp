package com.nttdata.practicadevara.projapp.shared.dto;

public enum SubscriptionStatusEnumDto {
    NULL(""), NEW("new"), ACCEPTED("accepted"), REJECTED("rejected");

    String value;

    SubscriptionStatusEnumDto(String v) {
        this.value = v;
    }

    public String value() {
        return value;
    }

    public static SubscriptionStatusEnumDto from(String value) {
        switch (value) {
            case "new":
                return NEW;
            case "accepted":
                return ACCEPTED;
            case "rejected":
                return REJECTED;
            default:

        }
        return NULL;
    }
    
}
