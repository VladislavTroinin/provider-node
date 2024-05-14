package org.vsu.provider.domain.model.file;

import org.springframework.lang.NonNull;

public record FileModel(@NonNull FileInfo fileInfo, @NonNull byte[] dataBytes) {

}
