package org.vsu.provider.domain.model.block;

import lombok.Builder;
import org.springframework.lang.NonNull;

@Builder
public record StorageBlock(@NonNull InfoBlock infoBlock,
                           @NonNull String infoBlockSignature,
                           @NonNull DataBlock dataBlock,
                           Integer lastBlockByteCount,
                           @NonNull String signature) {

}
