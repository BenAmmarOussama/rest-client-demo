package org.eniso.pmfwk.utils;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/*
* This class is needed to propagate Headers to external APIs (DropWizard API in our case)
* */
public class AuthorizationHeaderFactory implements ClientHeadersFactory {
    @Override
    public MultivaluedMap<String, String> update(
            MultivaluedMap<String, String> incomingHeaders,
            MultivaluedMap<String, String> clientOutgoingHeaders) {
        MultivaluedMap<String, String> result = new MultivaluedHashMap<>();
        result.add("Authorization", incomingHeaders.getFirst("Authorization"));
        return result;
    }
}
