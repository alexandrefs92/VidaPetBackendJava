package com.vidapet.backend.vidapet.backend.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5866400118018671167L;

    public DatabaseException(String msg) {
        super(msg);
    }
}
