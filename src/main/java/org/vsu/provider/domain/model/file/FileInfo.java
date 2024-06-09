package org.vsu.provider.domain.model.file;

import org.springframework.lang.NonNull;

public record FileInfo(@NonNull String userId, @NonNull String fileName) {

}
