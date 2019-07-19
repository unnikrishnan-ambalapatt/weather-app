package com.weather.weatherapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

/**
 * Error handling framework which could be enhanced to handle specific errors, retry service call etc.
 */
public class RemoteCallErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if((HttpStatus.Series.CLIENT_ERROR == response.getStatusCode().series()
                || HttpStatus.Series.SERVER_ERROR == response.getStatusCode().series())) {
            return true;
        }
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        /* UI could potentially handle these errors and provide options to retry */

        if(HttpStatus.Series.SERVER_ERROR == response.getStatusCode().series()) {
            throw new ResponseStatusException(response.getStatusCode(), response.getStatusText());
        } else {
            throw new IOException("Incorrect request. Please check the request parameters.");
        }
    }
}
