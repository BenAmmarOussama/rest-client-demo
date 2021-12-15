package org.eniso.pmfwk.ExceptionHandler;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.annotation.Priority;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


@Priority(1)
public class MyExceptionMapper implements ResponseExceptionMapper<RuntimeException> {
    @Override
    public RuntimeException toThrowable(Response response) {
        return new WebApplicationException(response);
    }
}