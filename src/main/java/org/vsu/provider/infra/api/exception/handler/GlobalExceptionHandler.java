package org.vsu.provider.infra.api.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.vsu.provider.infra.api.rest.dto.UnifiedResponse;
import org.vsu.provider.infra.api.rest.enumeration.ResponseStatusCode;
import org.vsu.provider.infra.api.rest.exception.UploadedFileReadingException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UploadedFileReadingException.class })
    public UnifiedResponse handleUploadedFileReadingException(UploadedFileReadingException e) {
        return UnifiedResponse.error(ResponseStatusCode.ERROR, e.getMessage());
    }

}
