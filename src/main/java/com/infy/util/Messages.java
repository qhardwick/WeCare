package com.infy.util;

import lombok.ToString;

public enum Messages {

    // Success messages:
    USER_CREATED_SUCCESS("user.created.success"),
    USER_DELETED_SUCCESS("user.deleted.success"),

    // Exception messages:
    USER_NOT_FOUND("user.not.found");

    private final String type;

    Messages(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
