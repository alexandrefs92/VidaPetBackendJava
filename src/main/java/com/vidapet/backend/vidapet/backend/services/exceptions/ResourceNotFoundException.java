package com.vidapet.backend.vidapet.backend.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8734823520773081171L;

    public ResourceNotFoundException(Object id) {
        super("Objeto não encontrado. Id: " + id );
    }

}
