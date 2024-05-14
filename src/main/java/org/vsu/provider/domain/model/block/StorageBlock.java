package org.vsu.provider.domain.model.block;

import org.springframework.lang.NonNull;

public record StorageBlock(@NonNull InfoBlock infoBlock,
                           @NonNull String infoBlockSignature,
                           @NonNull DataBlock dataBlock,
                           Integer lastBlockByteCount,
                           @NonNull String signature) {

}
