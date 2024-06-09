package org.vsu.provider.infra.api.rest.enumeration;

import lombok.Getter;

@Getter
public enum ResponseStatusCode {

    OK(0, "No error"),
    ERROR(1, "Error");

    private final int value;
    private final String notation;

    ResponseStatusCode(int value, String notation) {
        this.value = value;
        this.notation = notation;
    }

}
