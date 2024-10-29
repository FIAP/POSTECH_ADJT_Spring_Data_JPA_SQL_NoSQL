package com.talkevents.cassandra.models;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("phone")
public class Phone {

    private String type;
    private String number;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
