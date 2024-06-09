package org.vsu.provider.infra.api.rest.helper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.vsu.provider.app.message.ExceptionMessages;
import org.vsu.provider.infra.api.rest.exception.UploadedFileReadingException;

import java.io.IOException;
import java.util.Objects;

@Component
@AllArgsConstructor
public class FileHelper {

    private final ExceptionMessages exceptionMessages;

    public byte[] fetchFileBytes(MultipartFile file) {
        try {
            return Objects.requireNonNull(file.getBytes());
        } catch (IOException | NullPointerException e) {
            throw new UploadedFileReadingException(
                    exceptionMessages.cannotReadUploadedFile());
        }
    }

}
