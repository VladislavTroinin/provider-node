package org.vsu.provider.domain.model.block;

import org.springframework.lang.NonNull;

@Deprecated
public record BlockModel(@NonNull String userId,
                         @NonNull String fileName,
                         @NonNull Integer orderNumber,
                         @NonNull Integer byteCount,
                         @NonNull byte[] dataBytes) {

}
