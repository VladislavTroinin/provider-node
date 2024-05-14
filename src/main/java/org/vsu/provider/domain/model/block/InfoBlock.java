package org.vsu.provider.domain.model.block;

import org.springframework.lang.NonNull;

public record InfoBlock(@NonNull String userId,
                        @NonNull String fileName,
                        @NonNull Integer orderNumber,
                        Integer byteCount) {

}
