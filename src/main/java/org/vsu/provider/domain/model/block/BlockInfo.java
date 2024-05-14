package org.vsu.provider.domain.model.block;

import org.springframework.lang.NonNull;

@Deprecated
public record BlockInfo(@NonNull String userId,
                        @NonNull String fileName,
                        @NonNull Integer orderNumber) {

}
