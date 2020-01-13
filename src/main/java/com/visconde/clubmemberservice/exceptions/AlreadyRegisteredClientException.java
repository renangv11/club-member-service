package com.visconde.clubmemberservice.exceptions;

import lombok.Data;

@Data
public class AlreadyRegisteredClientException extends RuntimeException {

    public AlreadyRegisteredClientException(String message) {
        super(message);
    }

}
